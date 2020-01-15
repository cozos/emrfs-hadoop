package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.VisibleForTesting;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Equivalence;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ticker;
import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

class MapMakerInternalMap$Segment<K, V>
  extends ReentrantLock
{
  final MapMakerInternalMap<K, V> map;
  volatile int count;
  int modCount;
  int threshold;
  volatile AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table;
  final int maxSegmentSize;
  final ReferenceQueue<K> keyReferenceQueue;
  final ReferenceQueue<V> valueReferenceQueue;
  final Queue<MapMakerInternalMap.ReferenceEntry<K, V>> recencyQueue;
  final AtomicInteger readCount = new AtomicInteger();
  @GuardedBy("Segment.this")
  final Queue<MapMakerInternalMap.ReferenceEntry<K, V>> evictionQueue;
  @GuardedBy("Segment.this")
  final Queue<MapMakerInternalMap.ReferenceEntry<K, V>> expirationQueue;
  
  MapMakerInternalMap$Segment(MapMakerInternalMap<K, V> map, int initialCapacity, int maxSegmentSize)
  {
    this.map = map;
    this.maxSegmentSize = maxSegmentSize;
    initTable(newEntryArray(initialCapacity));
    
    keyReferenceQueue = (map.usesKeyReferences() ? new ReferenceQueue() : null);
    
    valueReferenceQueue = (map.usesValueReferences() ? new ReferenceQueue() : null);
    
    recencyQueue = ((map.evictsBySize()) || (map.expiresAfterAccess()) ? new ConcurrentLinkedQueue() : MapMakerInternalMap.discardingQueue());
    
    evictionQueue = (map.evictsBySize() ? new MapMakerInternalMap.EvictionQueue() : MapMakerInternalMap.discardingQueue());
    
    expirationQueue = (map.expires() ? new MapMakerInternalMap.ExpirationQueue() : MapMakerInternalMap.discardingQueue());
  }
  
  AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> newEntryArray(int size)
  {
    return new AtomicReferenceArray(size);
  }
  
  void initTable(AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> newTable)
  {
    threshold = (newTable.length() * 3 / 4);
    if (threshold == maxSegmentSize) {
      threshold += 1;
    }
    table = newTable;
  }
  
  @GuardedBy("Segment.this")
  MapMakerInternalMap.ReferenceEntry<K, V> newEntry(K key, int hash, @Nullable MapMakerInternalMap.ReferenceEntry<K, V> next)
  {
    return map.entryFactory.newEntry(this, key, hash, next);
  }
  
  @GuardedBy("Segment.this")
  MapMakerInternalMap.ReferenceEntry<K, V> copyEntry(MapMakerInternalMap.ReferenceEntry<K, V> original, MapMakerInternalMap.ReferenceEntry<K, V> newNext)
  {
    if (original.getKey() == null) {
      return null;
    }
    MapMakerInternalMap.ValueReference<K, V> valueReference = original.getValueReference();
    V value = valueReference.get();
    if ((value == null) && (!valueReference.isComputingReference())) {
      return null;
    }
    MapMakerInternalMap.ReferenceEntry<K, V> newEntry = map.entryFactory.copyEntry(this, original, newNext);
    newEntry.setValueReference(valueReference.copyFor(valueReferenceQueue, value, newEntry));
    return newEntry;
  }
  
  @GuardedBy("Segment.this")
  void setValue(MapMakerInternalMap.ReferenceEntry<K, V> entry, V value)
  {
    MapMakerInternalMap.ValueReference<K, V> valueReference = map.valueStrength.referenceValue(this, entry, value);
    entry.setValueReference(valueReference);
    recordWrite(entry);
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
  
  @GuardedBy("Segment.this")
  void drainReferenceQueues()
  {
    if (map.usesKeyReferences()) {
      drainKeyReferenceQueue();
    }
    if (map.usesValueReferences()) {
      drainValueReferenceQueue();
    }
  }
  
  @GuardedBy("Segment.this")
  void drainKeyReferenceQueue()
  {
    int i = 0;
    Reference<? extends K> ref;
    for (; (ref = keyReferenceQueue.poll()) != null; i == 16)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> entry = (MapMakerInternalMap.ReferenceEntry)ref;
      map.reclaimKey(entry);
      i++;
    }
  }
  
  @GuardedBy("Segment.this")
  void drainValueReferenceQueue()
  {
    int i = 0;
    Reference<? extends V> ref;
    for (; (ref = valueReferenceQueue.poll()) != null; i == 16)
    {
      MapMakerInternalMap.ValueReference<K, V> valueReference = (MapMakerInternalMap.ValueReference)ref;
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
  
  void recordRead(MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    if (map.expiresAfterAccess()) {
      recordExpirationTime(entry, map.expireAfterAccessNanos);
    }
    recencyQueue.add(entry);
  }
  
  @GuardedBy("Segment.this")
  void recordLockedRead(MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    evictionQueue.add(entry);
    if (map.expiresAfterAccess())
    {
      recordExpirationTime(entry, map.expireAfterAccessNanos);
      expirationQueue.add(entry);
    }
  }
  
  @GuardedBy("Segment.this")
  void recordWrite(MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    drainRecencyQueue();
    evictionQueue.add(entry);
    if (map.expires())
    {
      long expiration = map.expiresAfterAccess() ? map.expireAfterAccessNanos : map.expireAfterWriteNanos;
      
      recordExpirationTime(entry, expiration);
      expirationQueue.add(entry);
    }
  }
  
  @GuardedBy("Segment.this")
  void drainRecencyQueue()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e;
    while ((e = (MapMakerInternalMap.ReferenceEntry)recencyQueue.poll()) != null)
    {
      if (evictionQueue.contains(e)) {
        evictionQueue.add(e);
      }
      if ((map.expiresAfterAccess()) && (expirationQueue.contains(e))) {
        expirationQueue.add(e);
      }
    }
  }
  
  void recordExpirationTime(MapMakerInternalMap.ReferenceEntry<K, V> entry, long expirationNanos)
  {
    entry.setExpirationTime(map.ticker.read() + expirationNanos);
  }
  
  void tryExpireEntries()
  {
    if (tryLock()) {
      try
      {
        expireEntries();
      }
      finally
      {
        unlock();
      }
    }
  }
  
  @GuardedBy("Segment.this")
  void expireEntries()
  {
    drainRecencyQueue();
    if (expirationQueue.isEmpty()) {
      return;
    }
    long now = map.ticker.read();
    MapMakerInternalMap.ReferenceEntry<K, V> e;
    while (((e = (MapMakerInternalMap.ReferenceEntry)expirationQueue.peek()) != null) && (map.isExpired(e, now))) {
      if (!removeEntry(e, e.getHash(), MapMaker.RemovalCause.EXPIRED)) {
        throw new AssertionError();
      }
    }
  }
  
  void enqueueNotification(MapMakerInternalMap.ReferenceEntry<K, V> entry, MapMaker.RemovalCause cause)
  {
    enqueueNotification(entry.getKey(), entry.getHash(), entry.getValueReference().get(), cause);
  }
  
  void enqueueNotification(@Nullable K key, int hash, @Nullable V value, MapMaker.RemovalCause cause)
  {
    if (map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE)
    {
      MapMaker.RemovalNotification<K, V> notification = new MapMaker.RemovalNotification(key, value, cause);
      map.removalNotificationQueue.offer(notification);
    }
  }
  
  @GuardedBy("Segment.this")
  boolean evictEntries()
  {
    if ((map.evictsBySize()) && (count >= maxSegmentSize))
    {
      drainRecencyQueue();
      
      MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)evictionQueue.remove();
      if (!removeEntry(e, e.getHash(), MapMaker.RemovalCause.SIZE)) {
        throw new AssertionError();
      }
      return true;
    }
    return false;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> getFirst(int hash)
  {
    AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
    return (MapMakerInternalMap.ReferenceEntry)table.get(hash & table.length() - 1);
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> getEntry(Object key, int hash)
  {
    if (count != 0) {
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = getFirst(hash); e != null; e = e.getNext()) {
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
    }
    return null;
  }
  
  MapMakerInternalMap.ReferenceEntry<K, V> getLiveEntry(Object key, int hash)
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e = getEntry(key, hash);
    if (e == null) {
      return null;
    }
    if ((map.expires()) && (map.isExpired(e)))
    {
      tryExpireEntries();
      return null;
    }
    return e;
  }
  
  V get(Object key, int hash)
  {
    try
    {
      MapMakerInternalMap.ReferenceEntry<K, V> e = getLiveEntry(key, hash);
      if (e == null) {
        return null;
      }
      Object value = e.getValueReference().get();
      if (value != null) {
        recordRead(e);
      } else {
        tryDrainReferenceQueues();
      }
      return (V)value;
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
      MapMakerInternalMap.ReferenceEntry<K, V> e;
      if (count != 0)
      {
        e = getLiveEntry(key, hash);
        boolean bool;
        if (e == null) {
          return false;
        }
        return e.getValueReference().get() != null;
      }
      return 0;
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
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table;
      if (count != 0)
      {
        table = this.table;
        int length = table.length();
        for (int i = 0; i < length; i++) {
          for (MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)table.get(i); e != null; e = e.getNext())
          {
            V entryValue = getLiveValue(e);
            if (entryValue != null) {
              if (map.valueEquivalence.equivalent(value, entryValue)) {
                return true;
              }
            }
          }
        }
      }
      return 0;
    }
    finally
    {
      postReadCleanup();
    }
  }
  
  V put(K key, int hash, V value, boolean onlyIfAbsent)
  {
    lock();
    try
    {
      preWriteCleanup();
      
      int newCount = count + 1;
      if (newCount > threshold)
      {
        expand();
        newCount = count + 1;
      }
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      K entryKey;
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          V ?;
          if (entryValue == null)
          {
            modCount += 1;
            setValue(e, value);
            if (!valueReference.isComputingReference())
            {
              enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.COLLECTED);
              newCount = count;
            }
            else if (evictEntries())
            {
              newCount = count + 1;
            }
            count = newCount;
            return null;
          }
          if (onlyIfAbsent)
          {
            recordLockedRead(e);
            return entryValue;
          }
          modCount += 1;
          enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.REPLACED);
          setValue(e, value);
          return entryValue;
        }
      }
      modCount += 1;
      MapMakerInternalMap.ReferenceEntry<K, V> newEntry = newEntry(key, hash, first);
      setValue(newEntry, value);
      table.set(index, newEntry);
      if (evictEntries()) {
        newCount = count + 1;
      }
      count = newCount;
      return null;
    }
    finally
    {
      unlock();
      postWriteCleanup();
    }
  }
  
  @GuardedBy("Segment.this")
  void expand()
  {
    AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> oldTable = table;
    int oldCapacity = oldTable.length();
    if (oldCapacity >= 1073741824) {
      return;
    }
    int newCount = count;
    AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> newTable = newEntryArray(oldCapacity << 1);
    threshold = (newTable.length() * 3 / 4);
    int newMask = newTable.length() - 1;
    for (int oldIndex = 0; oldIndex < oldCapacity; oldIndex++)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> head = (MapMakerInternalMap.ReferenceEntry)oldTable.get(oldIndex);
      if (head != null)
      {
        MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNext();
        int headIndex = head.getHash() & newMask;
        if (next == null)
        {
          newTable.set(headIndex, head);
        }
        else
        {
          MapMakerInternalMap.ReferenceEntry<K, V> tail = head;
          int tailIndex = headIndex;
          for (MapMakerInternalMap.ReferenceEntry<K, V> e = next; e != null; e = e.getNext())
          {
            int newIndex = e.getHash() & newMask;
            if (newIndex != tailIndex)
            {
              tailIndex = newIndex;
              tail = e;
            }
          }
          newTable.set(tailIndex, tail);
          for (MapMakerInternalMap.ReferenceEntry<K, V> e = head; e != tail; e = e.getNext())
          {
            int newIndex = e.getHash() & newMask;
            MapMakerInternalMap.ReferenceEntry<K, V> newNext = (MapMakerInternalMap.ReferenceEntry)newTable.get(newIndex);
            MapMakerInternalMap.ReferenceEntry<K, V> newFirst = copyEntry(e, newNext);
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
      preWriteCleanup();
      
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          int newCount;
          if (entryValue == null)
          {
            if (isCollected(valueReference))
            {
              newCount = count - 1;
              modCount += 1;
              enqueueNotification(entryKey, hash, entryValue, MapMaker.RemovalCause.COLLECTED);
              MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
              newCount = count - 1;
              table.set(index, newFirst);
              count = newCount;
            }
            return 0;
          }
          if (map.valueEquivalence.equivalent(oldValue, entryValue))
          {
            modCount += 1;
            enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.REPLACED);
            setValue(e, newValue);
            return 1;
          }
          recordLockedRead(e);
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
  
  V replace(K key, int hash, V newValue)
  {
    lock();
    try
    {
      preWriteCleanup();
      
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          int newCount;
          if (entryValue == null)
          {
            if (isCollected(valueReference))
            {
              newCount = count - 1;
              modCount += 1;
              enqueueNotification(entryKey, hash, entryValue, MapMaker.RemovalCause.COLLECTED);
              MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
              newCount = count - 1;
              table.set(index, newFirst);
              count = newCount;
            }
            return null;
          }
          modCount += 1;
          enqueueNotification(key, hash, entryValue, MapMaker.RemovalCause.REPLACED);
          setValue(e, newValue);
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
  
  V remove(Object key, int hash)
  {
    lock();
    try
    {
      preWriteCleanup();
      
      int newCount = count - 1;
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          MapMaker.RemovalCause cause;
          if (entryValue != null)
          {
            cause = MapMaker.RemovalCause.EXPLICIT;
          }
          else
          {
            MapMaker.RemovalCause cause;
            if (isCollected(valueReference)) {
              cause = MapMaker.RemovalCause.COLLECTED;
            } else {
              return null;
            }
          }
          MapMaker.RemovalCause cause;
          modCount += 1;
          enqueueNotification(entryKey, hash, entryValue, cause);
          Object newFirst = removeFromChain(first, e);
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
  
  boolean remove(Object key, int hash, Object value)
  {
    lock();
    try
    {
      preWriteCleanup();
      
      int newCount = count - 1;
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          MapMakerInternalMap.ValueReference<K, V> valueReference = e.getValueReference();
          V entryValue = valueReference.get();
          MapMaker.RemovalCause cause;
          if (map.valueEquivalence.equivalent(value, entryValue))
          {
            cause = MapMaker.RemovalCause.EXPLICIT;
          }
          else
          {
            MapMaker.RemovalCause cause;
            if (isCollected(valueReference)) {
              cause = MapMaker.RemovalCause.COLLECTED;
            } else {
              return false;
            }
          }
          MapMaker.RemovalCause cause;
          modCount += 1;
          enqueueNotification(entryKey, hash, entryValue, cause);
          Object newFirst = removeFromChain(first, e);
          newCount = count - 1;
          table.set(index, newFirst);
          count = newCount;
          return cause == MapMaker.RemovalCause.EXPLICIT;
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
        AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
        if (map.removalNotificationQueue != MapMakerInternalMap.DISCARDING_QUEUE) {
          for (int i = 0; i < table.length(); i++) {
            for (MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)table.get(i); e != null; e = e.getNext()) {
              if (!e.getValueReference().isComputingReference()) {
                enqueueNotification(e, MapMaker.RemovalCause.EXPLICIT);
              }
            }
          }
        }
        for (int i = 0; i < table.length(); i++) {
          table.set(i, null);
        }
        clearReferenceQueues();
        evictionQueue.clear();
        expirationQueue.clear();
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
  
  @GuardedBy("Segment.this")
  MapMakerInternalMap.ReferenceEntry<K, V> removeFromChain(MapMakerInternalMap.ReferenceEntry<K, V> first, MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    evictionQueue.remove(entry);
    expirationQueue.remove(entry);
    
    int newCount = count;
    MapMakerInternalMap.ReferenceEntry<K, V> newFirst = entry.getNext();
    for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != entry; e = e.getNext())
    {
      MapMakerInternalMap.ReferenceEntry<K, V> next = copyEntry(e, newFirst);
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
  
  void removeCollectedEntry(MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    enqueueNotification(entry, MapMaker.RemovalCause.COLLECTED);
    evictionQueue.remove(entry);
    expirationQueue.remove(entry);
  }
  
  boolean reclaimKey(MapMakerInternalMap.ReferenceEntry<K, V> entry, int hash)
  {
    lock();
    try
    {
      int newCount = count - 1;
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext()) {
        if (e == entry)
        {
          modCount += 1;
          enqueueNotification(e.getKey(), hash, e.getValueReference().get(), MapMaker.RemovalCause.COLLECTED);
          
          MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
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
  
  boolean reclaimValue(K key, int hash, MapMakerInternalMap.ValueReference<K, V> valueReference)
  {
    lock();
    try
    {
      int newCount = count - 1;
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          MapMakerInternalMap.ValueReference<K, V> v = e.getValueReference();
          MapMakerInternalMap.ReferenceEntry<K, V> newFirst;
          if (v == valueReference)
          {
            modCount += 1;
            enqueueNotification(key, hash, valueReference.get(), MapMaker.RemovalCause.COLLECTED);
            newFirst = removeFromChain(first, e);
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
  
  boolean clearValue(K key, int hash, MapMakerInternalMap.ValueReference<K, V> valueReference)
  {
    lock();
    try
    {
      AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
      int index = hash & table.length() - 1;
      MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
      for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext())
      {
        K entryKey = e.getKey();
        if ((e.getHash() == hash) && (entryKey != null) && (map.keyEquivalence.equivalent(key, entryKey)))
        {
          MapMakerInternalMap.ValueReference<K, V> v = e.getValueReference();
          MapMakerInternalMap.ReferenceEntry<K, V> newFirst;
          if (v == valueReference)
          {
            newFirst = removeFromChain(first, e);
            table.set(index, newFirst);
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
      postWriteCleanup();
    }
  }
  
  @GuardedBy("Segment.this")
  boolean removeEntry(MapMakerInternalMap.ReferenceEntry<K, V> entry, int hash, MapMaker.RemovalCause cause)
  {
    int newCount = count - 1;
    AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> table = this.table;
    int index = hash & table.length() - 1;
    MapMakerInternalMap.ReferenceEntry<K, V> first = (MapMakerInternalMap.ReferenceEntry)table.get(index);
    for (MapMakerInternalMap.ReferenceEntry<K, V> e = first; e != null; e = e.getNext()) {
      if (e == entry)
      {
        modCount += 1;
        enqueueNotification(e.getKey(), hash, e.getValueReference().get(), cause);
        MapMakerInternalMap.ReferenceEntry<K, V> newFirst = removeFromChain(first, e);
        newCount = count - 1;
        table.set(index, newFirst);
        count = newCount;
        return true;
      }
    }
    return false;
  }
  
  boolean isCollected(MapMakerInternalMap.ValueReference<K, V> valueReference)
  {
    if (valueReference.isComputingReference()) {
      return false;
    }
    return valueReference.get() == null;
  }
  
  V getLiveValue(MapMakerInternalMap.ReferenceEntry<K, V> entry)
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
    if ((map.expires()) && (map.isExpired(entry)))
    {
      tryExpireEntries();
      return null;
    }
    return value;
  }
  
  void postReadCleanup()
  {
    if ((readCount.incrementAndGet() & 0x3F) == 0) {
      runCleanup();
    }
  }
  
  @GuardedBy("Segment.this")
  void preWriteCleanup()
  {
    runLockedCleanup();
  }
  
  void postWriteCleanup()
  {
    runUnlockedCleanup();
  }
  
  void runCleanup()
  {
    runLockedCleanup();
    runUnlockedCleanup();
  }
  
  void runLockedCleanup()
  {
    if (tryLock()) {
      try
      {
        drainReferenceQueues();
        expireEntries();
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.Segment
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */