package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ticker;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ExecutionError;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.MoreExecutors;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.UncheckedExecutionException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.Uninterruptibles;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class LocalCache$Segment<K, V>
  extends ReentrantLock
{
  final LocalCache<K, V> map;
  volatile int count;
  @GuardedBy("this")
  long totalWeight;
  int modCount;
  int threshold;
  volatile AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table;
  final long maxSegmentWeight;
  final ReferenceQueue<K> keyReferenceQueue;
  final ReferenceQueue<V> valueReferenceQueue;
  final Queue<LocalCache.ReferenceEntry<K, V>> recencyQueue;
  final AtomicInteger readCount = new AtomicInteger();
  @GuardedBy("this")
  final Queue<LocalCache.ReferenceEntry<K, V>> writeQueue;
  @GuardedBy("this")
  final Queue<LocalCache.ReferenceEntry<K, V>> accessQueue;
  final AbstractCache.StatsCounter statsCounter;
  
  LocalCache$Segment(LocalCache<K, V> map, int initialCapacity, long maxSegmentWeight, AbstractCache.StatsCounter statsCounter)
  {
    this.map = map;
    this.maxSegmentWeight = maxSegmentWeight;
    this.statsCounter = ((AbstractCache.StatsCounter)Preconditions.checkNotNull(statsCounter));
    initTable(newEntryArray(initialCapacity));
    
    keyReferenceQueue = (map.usesKeyReferences() ? new ReferenceQueue() : null);
    
    valueReferenceQueue = (map.usesValueReferences() ? new ReferenceQueue() : null);
    
    recencyQueue = (map.usesAccessQueue() ? new ConcurrentLinkedQueue() : LocalCache.discardingQueue());
    
    writeQueue = (map.usesWriteQueue() ? new LocalCache.WriteQueue() : LocalCache.discardingQueue());
    
    accessQueue = (map.usesAccessQueue() ? new LocalCache.AccessQueue() : LocalCache.discardingQueue());
  }
  
  AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> newEntryArray(int size)
  {
    return new AtomicReferenceArray(size);
  }
  
  void initTable(AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> newTable)
  {
    threshold = (newTable.length() * 3 / 4);
    if ((!map.customWeigher()) && (threshold == maxSegmentWeight)) {
      threshold += 1;
    }
    table = newTable;
  }
  
  @GuardedBy("this")
  LocalCache.ReferenceEntry<K, V> newEntry(K key, int hash, @Nullable LocalCache.ReferenceEntry<K, V> next)
  {
    return map.entryFactory.newEntry(this, Preconditions.checkNotNull(key), hash, next);
  }
  
  @GuardedBy("this")
  LocalCache.ReferenceEntry<K, V> copyEntry(LocalCache.ReferenceEntry<K, V> original, LocalCache.ReferenceEntry<K, V> newNext)
  {
    if (original.getKey() == null) {
      return null;
    }
    LocalCache.ValueReference<K, V> valueReference = original.getValueReference();
    V value = valueReference.get();
    if ((value == null) && (valueReference.isActive())) {
      return null;
    }
    LocalCache.ReferenceEntry<K, V> newEntry = map.entryFactory.copyEntry(this, original, newNext);
    newEntry.setValueReference(valueReference.copyFor(valueReferenceQueue, value, newEntry));
    return newEntry;
  }
  
  @GuardedBy("this")
  void setValue(LocalCache.ReferenceEntry<K, V> entry, K key, V value, long now)
  {
    LocalCache.ValueReference<K, V> previous = entry.getValueReference();
    int weight = map.weigher.weigh(key, value);
    Preconditions.checkState(weight >= 0, "Weights must be non-negative");
    
    LocalCache.ValueReference<K, V> valueReference = map.valueStrength.referenceValue(this, entry, value, weight);
    
    entry.setValueReference(valueReference);
    recordWrite(entry, weight, now);
    previous.notifyNewValue(value);
  }
  
  V get(K key, int hash, CacheLoader<? super K, V> loader)
    throws ExecutionException
  {
    Preconditions.checkNotNull(key);
    Preconditions.checkNotNull(loader);
    try
    {
      LocalCache.ReferenceEntry<K, V> e;
      if (count != 0)
      {
        e = getEntry(key, hash);
        if (e != null)
        {
          long now = map.ticker.read();
          V value = getLiveValue(e, now);
          if (value != null)
          {
            recordRead(e, now);
            statsCounter.recordHits(1);
            return (V)scheduleRefresh(e, key, hash, value, now, loader);
          }
          Object valueReference = e.getValueReference();
          if (((LocalCache.ValueReference)valueReference).isLoading()) {
            return (V)waitForLoadingValue(e, key, (LocalCache.ValueReference)valueReference);
          }
        }
      }
      return (V)lockedGetOrLoad(key, hash, loader);
    }
    catch (ExecutionException ee)
    {
      Throwable cause = ee.getCause();
      if ((cause instanceof Error)) {
        throw new ExecutionError((Error)cause);
      }
      if ((cause instanceof RuntimeException)) {
        throw new UncheckedExecutionException(cause);
      }
      throw ee;
    }
    finally
    {
      postReadCleanup();
    }
  }
  
  V lockedGetOrLoad(K key, int hash, CacheLoader<? super K, V> loader)
    throws ExecutionException
  {
    valueReference = null;
    LocalCache.LoadingValueReference<K, V> loadingValueReference = null;
    boolean createNewEntry = true;
    
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      int newCount = count - 1;
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          valueReference = e.getValueReference();
          if (valueReference.isLoading())
          {
            createNewEntry = false; break;
          }
          V value = valueReference.get();
          if (value == null)
          {
            enqueueNotification(entryKey, hash, valueReference, RemovalCause.COLLECTED);
          }
          else if (map.isExpired(e, now))
          {
            enqueueNotification(entryKey, hash, valueReference, RemovalCause.EXPIRED);
          }
          else
          {
            recordLockedRead(e, now);
            statsCounter.recordHits(1);
            
            return value;
          }
          writeQueue.remove(e);
          accessQueue.remove(e);
          count = newCount;
          
          break;
        }
      }
      if (createNewEntry)
      {
        loadingValueReference = new LocalCache.LoadingValueReference();
        if (e == null)
        {
          e = newEntry(key, hash, first);
          e.setValueReference(loadingValueReference);
          table.set(index, e);
        }
        else
        {
          e.setValueReference(loadingValueReference);
        }
      }
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
    if (createNewEntry) {
      try
      {
        synchronized (e)
        {
          return (V)loadSync(key, hash, loadingValueReference, loader);
        }
        return (V)waitForLoadingValue(e, key, valueReference);
      }
      finally
      {
        statsCounter.recordMisses(1);
      }
    }
  }
  
  V waitForLoadingValue(LocalCache.ReferenceEntry<K, V> e, K key, LocalCache.ValueReference<K, V> valueReference)
    throws ExecutionException
  {
    if (!valueReference.isLoading()) {
      throw new AssertionError();
    }
    Preconditions.checkState(!Thread.holdsLock(e), "Recursive load of: %s", new Object[] { key });
    try
    {
      V value = valueReference.waitForValue();
      if (value == null)
      {
        String str = String.valueOf(String.valueOf(key));throw new CacheLoader.InvalidCacheLoadException(35 + str.length() + "CacheLoader returned null for key " + str + ".");
      }
      long now = map.ticker.read();
      recordRead(e, now);
      return value;
    }
    finally
    {
      statsCounter.recordMisses(1);
    }
  }
  
  V loadSync(K key, int hash, LocalCache.LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> loader)
    throws ExecutionException
  {
    ListenableFuture<V> loadingFuture = loadingValueReference.loadFuture(key, loader);
    return (V)getAndRecordStats(key, hash, loadingValueReference, loadingFuture);
  }
  
  ListenableFuture<V> loadAsync(final K key, final int hash, final LocalCache.LoadingValueReference<K, V> loadingValueReference, CacheLoader<? super K, V> loader)
  {
    final ListenableFuture<V> loadingFuture = loadingValueReference.loadFuture(key, loader);
    loadingFuture.addListener(new Runnable()
    {
      public void run()
      {
        try
        {
          newValue = getAndRecordStats(key, hash, loadingValueReference, loadingFuture);
        }
        catch (Throwable t)
        {
          V newValue;
          LocalCache.logger.log(Level.WARNING, "Exception thrown during refresh", t);
          loadingValueReference.setException(t);
        }
      }
    }, MoreExecutors.directExecutor());
    
    return loadingFuture;
  }
  
  V getAndRecordStats(K key, int hash, LocalCache.LoadingValueReference<K, V> loadingValueReference, ListenableFuture<V> newValue)
    throws ExecutionException
  {
    V value = null;
    try
    {
      value = Uninterruptibles.getUninterruptibly(newValue);
      Object localObject1;
      if (value == null)
      {
        localObject1 = String.valueOf(String.valueOf(key));throw new CacheLoader.InvalidCacheLoadException(35 + ((String)localObject1).length() + "CacheLoader returned null for key " + (String)localObject1 + ".");
      }
      statsCounter.recordLoadSuccess(loadingValueReference.elapsedNanos());
      storeLoadedValue(key, hash, loadingValueReference, value);
      return value;
    }
    finally
    {
      if (value == null)
      {
        statsCounter.recordLoadException(loadingValueReference.elapsedNanos());
        removeLoadingValue(key, hash, loadingValueReference);
      }
    }
  }
  
  V scheduleRefresh(LocalCache.ReferenceEntry<K, V> entry, K key, int hash, V oldValue, long now, CacheLoader<? super K, V> loader)
  {
    if ((map.refreshes()) && (now - entry.getWriteTime() > map.refreshNanos) && (!entry.getValueReference().isLoading()))
    {
      V newValue = refresh(key, hash, loader, true);
      if (newValue != null) {
        return newValue;
      }
    }
    return oldValue;
  }
  
  @Nullable
  V refresh(K key, int hash, CacheLoader<? super K, V> loader, boolean checkTime)
  {
    LocalCache.LoadingValueReference<K, V> loadingValueReference = insertLoadingValueReference(key, hash, checkTime);
    if (loadingValueReference == null) {
      return null;
    }
    ListenableFuture<V> result = loadAsync(key, hash, loadingValueReference, loader);
    if (result.isDone()) {
      try
      {
        return (V)Uninterruptibles.getUninterruptibly(result);
      }
      catch (Throwable t) {}
    }
    return null;
  }
  
  @Nullable
  LocalCache.LoadingValueReference<K, V> insertLoadingValueReference(K key, int hash, boolean checkTime)
  {
    LocalCache.ReferenceEntry<K, V> e = null;
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      LocalCache.ValueReference<K, V> valueReference;
      for (e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          valueReference = e.getValueReference();
          if ((valueReference.isLoading()) || ((checkTime) && (now - e.getWriteTime() < map.refreshNanos))) {
            return null;
          }
          modCount += 1;
          Object loadingValueReference = new LocalCache.LoadingValueReference(valueReference);
          
          e.setValueReference((LocalCache.ValueReference)loadingValueReference);
          return (LocalCache.LoadingValueReference<K, V>)loadingValueReference;
        }
      }
      modCount += 1;
      LocalCache.LoadingValueReference<K, V> loadingValueReference = new LocalCache.LoadingValueReference();
      e = newEntry(key, hash, first);
      e.setValueReference(loadingValueReference);
      table.set(index, e);
      return loadingValueReference;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  void tryDrainReferenceQueues()
  {
    if (tryLock()) {
      try
      {
        drainReferenceQueues();
      }
      finally
      {
        unlock();
      }
    }
  }
  
  @GuardedBy("this")
  void drainReferenceQueues()
  {
    if (map.usesKeyReferences()) {
      drainKeyReferenceQueue();
    }
    if (map.usesValueReferences()) {
      drainValueReferenceQueue();
    }
  }
  
  @GuardedBy("this")
  void drainKeyReferenceQueue()
  {
    int i = 0;
    Reference<? extends K> ref;
    for (; (ref = keyReferenceQueue.poll()) != null; i == 16)
    {
      LocalCache.ReferenceEntry<K, V> entry = (LocalCache.ReferenceEntry)ref;
      map.reclaimKey(entry);
      i++;
    }
  }
  
  @GuardedBy("this")
  void drainValueReferenceQueue()
  {
    int i = 0;
    Reference<? extends V> ref;
    for (; (ref = valueReferenceQueue.poll()) != null; i == 16)
    {
      LocalCache.ValueReference<K, V> valueReference = (LocalCache.ValueReference)ref;
      map.reclaimValue(valueReference);
      i++;
    }
  }
  
  void clearReferenceQueues()
  {
    if (map.usesKeyReferences()) {
      clearKeyReferenceQueue();
    }
    if (map.usesValueReferences()) {
      clearValueReferenceQueue();
    }
  }
  
  void clearKeyReferenceQueue()
  {
    while (keyReferenceQueue.poll() != null) {}
  }
  
  void clearValueReferenceQueue()
  {
    while (valueReferenceQueue.poll() != null) {}
  }
  
  void recordRead(LocalCache.ReferenceEntry<K, V> entry, long now)
  {
    if (map.recordsAccess()) {
      entry.setAccessTime(now);
    }
    recencyQueue.add(entry);
  }
  
  @GuardedBy("this")
  void recordLockedRead(LocalCache.ReferenceEntry<K, V> entry, long now)
  {
    if (map.recordsAccess()) {
      entry.setAccessTime(now);
    }
    accessQueue.add(entry);
  }
  
  @GuardedBy("this")
  void recordWrite(LocalCache.ReferenceEntry<K, V> entry, int weight, long now)
  {
    drainRecencyQueue();
    totalWeight += weight;
    if (map.recordsAccess()) {
      entry.setAccessTime(now);
    }
    if (map.recordsWrite()) {
      entry.setWriteTime(now);
    }
    accessQueue.add(entry);
    writeQueue.add(entry);
  }
  
  @GuardedBy("this")
  void drainRecencyQueue()
  {
    LocalCache.ReferenceEntry<K, V> e;
    while ((e = (LocalCache.ReferenceEntry)recencyQueue.poll()) != null) {
      if (accessQueue.contains(e)) {
        accessQueue.add(e);
      }
    }
  }
  
  void tryExpireEntries(long now)
  {
    if (tryLock()) {
      try
      {
        expireEntries(now);
      }
      finally
      {
        unlock();
      }
    }
  }
  
  @GuardedBy("this")
  void expireEntries(long now)
  {
    drainRecencyQueue();
    LocalCache.ReferenceEntry<K, V> e;
    while (((e = (LocalCache.ReferenceEntry)writeQueue.peek()) != null) && (map.isExpired(e, now))) {
      if (!removeEntry(e, e.getHash(), RemovalCause.EXPIRED)) {
        throw new AssertionError();
      }
    }
    while (((e = (LocalCache.ReferenceEntry)accessQueue.peek()) != null) && (map.isExpired(e, now))) {
      if (!removeEntry(e, e.getHash(), RemovalCause.EXPIRED)) {
        throw new AssertionError();
      }
    }
  }
  
  @GuardedBy("this")
  void enqueueNotification(LocalCache.ReferenceEntry<K, V> entry, RemovalCause cause)
  {
    enqueueNotification(entry.getKey(), entry.getHash(), entry.getValueReference(), cause);
  }
  
  @GuardedBy("this")
  void enqueueNotification(@Nullable K key, int hash, LocalCache.ValueReference<K, V> valueReference, RemovalCause cause)
  {
    totalWeight -= valueReference.getWeight();
    if (cause.wasEvicted()) {
      statsCounter.recordEviction();
    }
    if (map.removalNotificationQueue != LocalCache.DISCARDING_QUEUE)
    {
      V value = valueReference.get();
      RemovalNotification<K, V> notification = new RemovalNotification(key, value, cause);
      map.removalNotificationQueue.offer(notification);
    }
  }
  
  @GuardedBy("this")
  void evictEntries()
  {
    if (!map.evictsBySize()) {
      return;
    }
    drainRecencyQueue();
    while (totalWeight > maxSegmentWeight)
    {
      LocalCache.ReferenceEntry<K, V> e = getNextEvictable();
      if (!removeEntry(e, e.getHash(), RemovalCause.SIZE)) {
        throw new AssertionError();
      }
    }
  }
  
  @GuardedBy("this")
  LocalCache.ReferenceEntry<K, V> getNextEvictable()
  {
    for (LocalCache.ReferenceEntry<K, V> e : accessQueue)
    {
      int weight = e.getValueReference().getWeight();
      if (weight > 0) {
        return e;
      }
    }
    throw new AssertionError();
  }
  
  LocalCache.ReferenceEntry<K, V> getFirst(int hash)
  {
    AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
    return (LocalCache.ReferenceEntry)table.get(hash & table.length() - 1);
  }
  
  @Nullable
  LocalCache.ReferenceEntry<K, V> getEntry(Object key, int hash)
  {
    for (LocalCache.ReferenceEntry<K, V> e = getFirst(hash); e != null; e = e.getNext()) {
      if (e.getHash() == hash)
      {
        K entryKey = e.getKey();
        if (entryKey == null) {
          tryDrainReferenceQueues();
        } else if (map.keyEquivalence.equivalent(key, entryKey)) {
          return e;
        }
      }
    }
    return null;
  }
  
  @Nullable
  LocalCache.ReferenceEntry<K, V> getLiveEntry(Object key, int hash, long now)
  {
    LocalCache.ReferenceEntry<K, V> e = getEntry(key, hash);
    if (e == null) {
      return null;
    }
    if (map.isExpired(e, now))
    {
      tryExpireEntries(now);
      return null;
    }
    return e;
  }
  
  V getLiveValue(LocalCache.ReferenceEntry<K, V> entry, long now)
  {
    if (entry.getKey() == null)
    {
      tryDrainReferenceQueues();
      return null;
    }
    V value = entry.getValueReference().get();
    if (value == null)
    {
      tryDrainReferenceQueues();
      return null;
    }
    if (map.isExpired(entry, now))
    {
      tryExpireEntries(now);
      return null;
    }
    return value;
  }
  
  @Nullable
  V get(Object key, int hash)
  {
    try
    {
      if (count != 0)
      {
        long now = map.ticker.read();
        LocalCache.ReferenceEntry<K, V> e = getLiveEntry(key, hash, now);
        if (e == null) {
          return null;
        }
        Object value = e.getValueReference().get();
        if (value != null)
        {
          recordRead(e, now);
          return (V)scheduleRefresh(e, e.getKey(), hash, value, now, map.defaultLoader);
        }
        tryDrainReferenceQueues();
      }
      return null;
    }
    finally
    {
      postReadCleanup();
    }
  }
  
  boolean containsKey(Object key, int hash)
  {
    try
    {
      if (count != 0)
      {
        long now = map.ticker.read();
        LocalCache.ReferenceEntry<K, V> e = getLiveEntry(key, hash, now);
        boolean bool1;
        if (e == null) {
          return false;
        }
        return e.getValueReference().get() != null;
      }
      return false;
    }
    finally
    {
      postReadCleanup();
    }
  }
  
  @VisibleForTesting
  boolean containsValue(Object value)
  {
    try
    {
      if (count != 0)
      {
        long now = map.ticker.read();
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
        int length = table.length();
        for (int i = 0; i < length; i++) {
          for (LocalCache.ReferenceEntry<K, V> e = (LocalCache.ReferenceEntry)table.get(i); e != null; e = e.getNext())
          {
            V entryValue = getLiveValue(e, now);
            if (entryValue != null) {
              if (map.valueEquivalence.equivalent(value, entryValue)) {
                return true;
              }
            }
          }
        }
      }
      return false;
    }
    finally
    {
      postReadCleanup();
    }
  }
  
  @Nullable
  V put(K key, int hash, V value, boolean onlyIfAbsent)
  {
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      int newCount = count + 1;
      if (newCount > threshold)
      {
        expand();
        newCount = count + 1;
      }
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      K entryKey;
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          V ?;
          if (entryValue == null)
          {
            modCount += 1;
            if (valueReference.isActive())
            {
              enqueueNotification(key, hash, valueReference, RemovalCause.COLLECTED);
              setValue(e, key, value, now);
              newCount = count;
            }
            else
            {
              setValue(e, key, value, now);
              newCount = count + 1;
            }
            count = newCount;
            evictEntries();
            return null;
          }
          if (onlyIfAbsent)
          {
            recordLockedRead(e, now);
            return entryValue;
          }
          modCount += 1;
          enqueueNotification(key, hash, valueReference, RemovalCause.REPLACED);
          setValue(e, key, value, now);
          evictEntries();
          return entryValue;
        }
      }
      modCount += 1;
      LocalCache.ReferenceEntry<K, V> newEntry = newEntry(key, hash, first);
      setValue(newEntry, key, value, now);
      table.set(index, newEntry);
      newCount = count + 1;
      count = newCount;
      evictEntries();
      return null;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  @GuardedBy("this")
  void expand()
  {
    AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> oldTable = table;
    int oldCapacity = oldTable.length();
    if (oldCapacity >= 1073741824) {
      return;
    }
    int newCount = count;
    AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> newTable = newEntryArray(oldCapacity << 1);
    threshold = (newTable.length() * 3 / 4);
    int newMask = newTable.length() - 1;
    for (int oldIndex = 0; oldIndex < oldCapacity; oldIndex++)
    {
      LocalCache.ReferenceEntry<K, V> head = (LocalCache.ReferenceEntry)oldTable.get(oldIndex);
      if (head != null)
      {
        LocalCache.ReferenceEntry<K, V> next = head.getNext();
        int headIndex = head.getHash() & newMask;
        if (next == null)
        {
          newTable.set(headIndex, head);
        }
        else
        {
          LocalCache.ReferenceEntry<K, V> tail = head;
          int tailIndex = headIndex;
          for (LocalCache.ReferenceEntry<K, V> e = next; e != null; e = e.getNext())
          {
            int newIndex = e.getHash() & newMask;
            if (newIndex != tailIndex)
            {
              tailIndex = newIndex;
              tail = e;
            }
          }
          newTable.set(tailIndex, tail);
          for (LocalCache.ReferenceEntry<K, V> e = head; e != tail; e = e.getNext())
          {
            int newIndex = e.getHash() & newMask;
            LocalCache.ReferenceEntry<K, V> newNext = (LocalCache.ReferenceEntry)newTable.get(newIndex);
            LocalCache.ReferenceEntry<K, V> newFirst = copyEntry(e, newNext);
            if (newFirst != null)
            {
              newTable.set(newIndex, newFirst);
            }
            else
            {
              removeCollectedEntry(e);
              newCount--;
            }
          }
        }
      }
    }
    table = newTable;
    count = newCount;
  }
  
  boolean replace(K key, int hash, V oldValue, V newValue)
  {
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          int newCount;
          if (entryValue == null)
          {
            if (valueReference.isActive())
            {
              newCount = count - 1;
              modCount += 1;
              LocalCache.ReferenceEntry<K, V> newFirst = removeValueFromChain(first, e, entryKey, hash, valueReference, RemovalCause.COLLECTED);
              
              newCount = count - 1;
              table.set(index, newFirst);
              count = newCount;
            }
            return 0;
          }
          if (map.valueEquivalence.equivalent(oldValue, entryValue))
          {
            modCount += 1;
            enqueueNotification(key, hash, valueReference, RemovalCause.REPLACED);
            setValue(e, key, newValue, now);
            evictEntries();
            return 1;
          }
          recordLockedRead(e, now);
          return 0;
        }
      }
      return 0;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  @Nullable
  V replace(K key, int hash, V newValue)
  {
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          int newCount;
          if (entryValue == null)
          {
            if (valueReference.isActive())
            {
              newCount = count - 1;
              modCount += 1;
              LocalCache.ReferenceEntry<K, V> newFirst = removeValueFromChain(first, e, entryKey, hash, valueReference, RemovalCause.COLLECTED);
              
              newCount = count - 1;
              table.set(index, newFirst);
              count = newCount;
            }
            return null;
          }
          modCount += 1;
          enqueueNotification(key, hash, valueReference, RemovalCause.REPLACED);
          setValue(e, key, newValue, now);
          evictEntries();
          return entryValue;
        }
      }
      return null;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  @Nullable
  V remove(Object key, int hash)
  {
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      int newCount = count - 1;
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          RemovalCause cause;
          if (entryValue != null)
          {
            cause = RemovalCause.EXPLICIT;
          }
          else
          {
            RemovalCause cause;
            if (valueReference.isActive()) {
              cause = RemovalCause.COLLECTED;
            } else {
              return null;
            }
          }
          RemovalCause cause;
          modCount += 1;
          Object newFirst = removeValueFromChain(first, e, entryKey, hash, valueReference, cause);
          
          newCount = count - 1;
          table.set(index, newFirst);
          count = newCount;
          return entryValue;
        }
      }
      return null;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  boolean storeLoadedValue(K key, int hash, LocalCache.LoadingValueReference<K, V> oldValueReference, V newValue)
  {
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      int newCount = count + 1;
      if (newCount > threshold)
      {
        expand();
        newCount = count + 1;
      }
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      K entryKey;
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          RemovalCause cause;
          if ((oldValueReference == valueReference) || ((entryValue == null) && (valueReference != LocalCache.UNSET)))
          {
            modCount += 1;
            if (oldValueReference.isActive())
            {
              cause = entryValue == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED;
              
              enqueueNotification(key, hash, oldValueReference, cause);
              newCount--;
            }
            setValue(e, key, newValue, now);
            count = newCount;
            evictEntries();
            return 1;
          }
          valueReference = new LocalCache.WeightedStrongValueReference(newValue, 0);
          enqueueNotification(key, hash, valueReference, RemovalCause.REPLACED);
          return 0;
        }
      }
      modCount += 1;
      LocalCache.ReferenceEntry<K, V> newEntry = newEntry(key, hash, first);
      setValue(newEntry, key, newValue, now);
      table.set(index, newEntry);
      count = newCount;
      evictEntries();
      return 1;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  boolean remove(Object key, int hash, Object value)
  {
    lock();
    try
    {
      long now = map.ticker.read();
      preWriteCleanup(now);
      
      int newCount = count - 1;
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          RemovalCause cause;
          if (map.valueEquivalence.equivalent(value, entryValue))
          {
            cause = RemovalCause.EXPLICIT;
          }
          else
          {
            RemovalCause cause;
            if ((entryValue == null) && (valueReference.isActive())) {
              cause = RemovalCause.COLLECTED;
            } else {
              return false;
            }
          }
          RemovalCause cause;
          modCount += 1;
          Object newFirst = removeValueFromChain(first, e, entryKey, hash, valueReference, cause);
          
          newCount = count - 1;
          table.set(index, newFirst);
          count = newCount;
          return cause == RemovalCause.EXPLICIT;
        }
      }
      return 0;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  void clear()
  {
    if (count != 0)
    {
      lock();
      try
      {
        AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
        for (int i = 0; i < table.length(); i++) {
          for (LocalCache.ReferenceEntry<K, V> e = (LocalCache.ReferenceEntry)table.get(i); e != null; e = e.getNext()) {
            if (e.getValueReference().isActive()) {
              enqueueNotification(e, RemovalCause.EXPLICIT);
            }
          }
        }
        for (int i = 0; i < table.length(); i++) {
          table.set(i, null);
        }
        clearReferenceQueues();
        writeQueue.clear();
        accessQueue.clear();
        readCount.set(0);
        
        modCount += 1;
        count = 0;
      }
      finally
      {
        unlock();
        postWriteCleanup();
      }
    }
  }
  
  @Nullable
  @GuardedBy("this")
  LocalCache.ReferenceEntry<K, V> removeValueFromChain(LocalCache.ReferenceEntry<K, V> first, LocalCache.ReferenceEntry<K, V> entry, @Nullable K key, int hash, LocalCache.ValueReference<K, V> valueReference, RemovalCause cause)
  {
    enqueueNotification(key, hash, valueReference, cause);
    writeQueue.remove(entry);
    accessQueue.remove(entry);
    if (valueReference.isLoading())
    {
      valueReference.notifyNewValue(null);
      return first;
    }
    return removeEntryFromChain(first, entry);
  }
  
  @Nullable
  @GuardedBy("this")
  LocalCache.ReferenceEntry<K, V> removeEntryFromChain(LocalCache.ReferenceEntry<K, V> first, LocalCache.ReferenceEntry<K, V> entry)
  {
    int newCount = count;
    LocalCache.ReferenceEntry<K, V> newFirst = entry.getNext();
    for (LocalCache.ReferenceEntry<K, V> e = first; e != entry; e = e.getNext())
    {
      LocalCache.ReferenceEntry<K, V> next = copyEntry(e, newFirst);
      if (next != null)
      {
        newFirst = next;
      }
      else
      {
        removeCollectedEntry(e);
        newCount--;
      }
    }
    count = newCount;
    return newFirst;
  }
  
  @GuardedBy("this")
  void removeCollectedEntry(LocalCache.ReferenceEntry<K, V> entry)
  {
    enqueueNotification(entry, RemovalCause.COLLECTED);
    writeQueue.remove(entry);
    accessQueue.remove(entry);
  }
  
  boolean reclaimKey(LocalCache.ReferenceEntry<K, V> entry, int hash)
  {
    lock();
    try
    {
      int newCount = count - 1;
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext()) {
        if (e == entry)
        {
          modCount += 1;
          LocalCache.ReferenceEntry<K, V> newFirst = removeValueFromChain(first, e, e.getKey(), hash, e.getValueReference(), RemovalCause.COLLECTED);
          
          newCount = count - 1;
          table.set(index, newFirst);
          count = newCount;
          return true;
        }
      }
      return 0;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  boolean reclaimValue(K key, int hash, LocalCache.ValueReference<K, V> valueReference)
  {
    lock();
    try
    {
      int newCount = count - 1;
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> v = e.getValueReference();
          LocalCache.ReferenceEntry<K, V> newFirst;
          if (v == valueReference)
          {
            modCount += 1;
            newFirst = removeValueFromChain(first, e, entryKey, hash, valueReference, RemovalCause.COLLECTED);
            
            newCount = count - 1;
            table.set(index, newFirst);
            count = newCount;
            return true;
          }
          return 0;
        }
      }
      return 0;
    }
    finally
    {
      unlock();
      if (!isHeldByCurrentThread()) {
        postWriteCleanup();
      }
    }
  }
  
  boolean removeLoadingValue(K key, int hash, LocalCache.LoadingValueReference<K, V> valueReference)
  {
    lock();
    try
    {
      AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
      for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          LocalCache.ValueReference<K, V> v = e.getValueReference();
          LocalCache.ReferenceEntry<K, V> newFirst;
          if (v == valueReference)
          {
            if (valueReference.isActive())
            {
              e.setValueReference(valueReference.getOldValue());
            }
            else
            {
              newFirst = removeEntryFromChain(first, e);
              table.set(index, newFirst);
            }
            return 1;
          }
          return 0;
        }
      }
      return 0;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  @GuardedBy("this")
  boolean removeEntry(LocalCache.ReferenceEntry<K, V> entry, int hash, RemovalCause cause)
  {
    int newCount = count - 1;
    AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> table = this.table;
    int index = hash & table.length() - 1;
    LocalCache.ReferenceEntry<K, V> first = (LocalCache.ReferenceEntry)table.get(index);
    for (LocalCache.ReferenceEntry<K, V> e = first; e != null; e = e.getNext()) {
      if (e == entry)
      {
        modCount += 1;
        LocalCache.ReferenceEntry<K, V> newFirst = removeValueFromChain(first, e, e.getKey(), hash, e.getValueReference(), cause);
        
        newCount = count - 1;
        table.set(index, newFirst);
        count = newCount;
        return true;
      }
    }
    return false;
  }
  
  void postReadCleanup()
  {
    if ((readCount.incrementAndGet() & 0x3F) == 0) {
      cleanUp();
    }
  }
  
  @GuardedBy("this")
  void preWriteCleanup(long now)
  {
    runLockedCleanup(now);
  }
  
  void postWriteCleanup()
  {
    runUnlockedCleanup();
  }
  
  void cleanUp()
  {
    long now = map.ticker.read();
    runLockedCleanup(now);
    runUnlockedCleanup();
  }
  
  void runLockedCleanup(long now)
  {
    if (tryLock()) {
      try
      {
        drainReferenceQueues();
        expireEntries(now);
        readCount.set(0);
      }
      finally
      {
        unlock();
      }
    }
  }
  
  void runUnlockedCleanup()
  {
    if (!isHeldByCurrentThread()) {
      map.processPendingNotifications();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.Segment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */