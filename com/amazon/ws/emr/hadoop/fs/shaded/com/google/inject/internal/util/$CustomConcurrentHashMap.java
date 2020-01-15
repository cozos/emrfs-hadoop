package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

final class $CustomConcurrentHashMap
{
  static final class Builder
  {
    float loadFactor = 0.75F;
    int initialCapacity = 16;
    int concurrencyLevel = 16;
    
    public Builder loadFactor(float loadFactor)
    {
      if (loadFactor <= 0.0F) {
        throw new IllegalArgumentException();
      }
      this.loadFactor = loadFactor;
      return this;
    }
    
    public Builder initialCapacity(int initialCapacity)
    {
      if (initialCapacity < 0) {
        throw new IllegalArgumentException();
      }
      this.initialCapacity = initialCapacity;
      return this;
    }
    
    public Builder concurrencyLevel(int concurrencyLevel)
    {
      if (concurrencyLevel <= 0) {
        throw new IllegalArgumentException();
      }
      this.concurrencyLevel = concurrencyLevel;
      return this;
    }
    
    public <K, V, E> ConcurrentMap<K, V> buildMap(.CustomConcurrentHashMap.Strategy<K, V, E> strategy)
    {
      if (strategy == null) {
        throw new NullPointerException("strategy");
      }
      return new .CustomConcurrentHashMap.Impl(strategy, this);
    }
    
    public <K, V, E> ConcurrentMap<K, V> buildComputingMap(.CustomConcurrentHashMap.ComputingStrategy<K, V, E> strategy, .Function<? super K, ? extends V> computer)
    {
      if (strategy == null) {
        throw new NullPointerException("strategy");
      }
      if (computer == null) {
        throw new NullPointerException("computer");
      }
      return new .CustomConcurrentHashMap.ComputingImpl(strategy, this, computer);
    }
  }
  
  private static int rehash(int h)
  {
    h += (h << 15 ^ 0xCD7D);
    h ^= h >>> 10;
    h += (h << 3);
    h ^= h >>> 6;
    h += (h << 2) + (h << 14);
    return h ^ h >>> 16;
  }
  
  public static abstract interface Strategy<K, V, E>
  {
    public abstract E newEntry(K paramK, int paramInt, E paramE);
    
    public abstract E copyEntry(K paramK, E paramE1, E paramE2);
    
    public abstract void setValue(E paramE, V paramV);
    
    public abstract V getValue(E paramE);
    
    public abstract boolean equalKeys(K paramK, Object paramObject);
    
    public abstract boolean equalValues(V paramV, Object paramObject);
    
    public abstract int hashKey(Object paramObject);
    
    public abstract K getKey(E paramE);
    
    public abstract E getNext(E paramE);
    
    public abstract int getHash(E paramE);
    
    public abstract void setInternals(.CustomConcurrentHashMap.Internals<K, V, E> paramInternals);
  }
  
  public static abstract interface Internals<K, V, E>
  {
    public abstract E getEntry(K paramK);
    
    public abstract boolean removeEntry(E paramE, @.Nullable V paramV);
    
    public abstract boolean removeEntry(E paramE);
  }
  
  public static abstract interface ComputingStrategy<K, V, E>
    extends .CustomConcurrentHashMap.Strategy<K, V, E>
  {
    public abstract V compute(K paramK, E paramE, .Function<? super K, ? extends V> paramFunction);
    
    public abstract V waitForValue(E paramE)
      throws InterruptedException;
  }
  
  static class Impl<K, V, E>
    extends AbstractMap<K, V>
    implements ConcurrentMap<K, V>, Serializable
  {
    static final int MAXIMUM_CAPACITY = 1073741824;
    static final int MAX_SEGMENTS = 65536;
    static final int RETRIES_BEFORE_LOCK = 2;
    final .CustomConcurrentHashMap.Strategy<K, V, E> strategy;
    final int segmentMask;
    final int segmentShift;
    final Impl<K, V, E>[].Segment segments;
    final float loadFactor;
    Set<K> keySet;
    Collection<V> values;
    Set<Map.Entry<K, V>> entrySet;
    private static final long serialVersionUID = 0L;
    
    Impl(.CustomConcurrentHashMap.Strategy<K, V, E> strategy, .CustomConcurrentHashMap.Builder builder)
    {
      loadFactor = loadFactor;
      int concurrencyLevel = concurrencyLevel;
      int initialCapacity = initialCapacity;
      if (concurrencyLevel > 65536) {
        concurrencyLevel = 65536;
      }
      int segmentShift = 0;
      int segmentCount = 1;
      while (segmentCount < concurrencyLevel)
      {
        segmentShift++;
        segmentCount <<= 1;
      }
      this.segmentShift = (32 - segmentShift);
      segmentMask = (segmentCount - 1);
      segments = newSegmentArray(segmentCount);
      if (initialCapacity > 1073741824) {
        initialCapacity = 1073741824;
      }
      int segmentCapacity = initialCapacity / segmentCount;
      if (segmentCapacity * segmentCount < initialCapacity) {
        segmentCapacity++;
      }
      int segmentSize = 1;
      while (segmentSize < segmentCapacity) {
        segmentSize <<= 1;
      }
      for (int i = 0; i < segments.length; i++) {
        segments[i] = new Segment(segmentSize);
      }
      this.strategy = strategy;
      
      strategy.setInternals(new InternalsImpl());
    }
    
    int hash(Object key)
    {
      int h = strategy.hashKey(key);
      return .CustomConcurrentHashMap.rehash(h);
    }
    
    class InternalsImpl
      implements .CustomConcurrentHashMap.Internals<K, V, E>, Serializable
    {
      static final long serialVersionUID = 0L;
      
      InternalsImpl() {}
      
      public E getEntry(K key)
      {
        if (key == null) {
          throw new NullPointerException("key");
        }
        int hash = hash(key);
        return (E)segmentFor(hash).getEntry(key, hash);
      }
      
      public boolean removeEntry(E entry, V value)
      {
        if (entry == null) {
          throw new NullPointerException("entry");
        }
        int hash = strategy.getHash(entry);
        return segmentFor(hash).removeEntry(entry, hash, value);
      }
      
      public boolean removeEntry(E entry)
      {
        if (entry == null) {
          throw new NullPointerException("entry");
        }
        int hash = strategy.getHash(entry);
        return segmentFor(hash).removeEntry(entry, hash);
      }
    }
    
    Impl<K, V, E>[].Segment newSegmentArray(int ssize)
    {
      return (Segment[])Array.newInstance(Segment.class, ssize);
    }
    
    Impl<K, V, E>.Segment segmentFor(int hash)
    {
      return segments[(hash >>> segmentShift & segmentMask)];
    }
    
    final class Segment
      extends ReentrantLock
    {
      volatile int count;
      int modCount;
      int threshold;
      volatile AtomicReferenceArray<E> table;
      
      Segment(int initialCapacity)
      {
        setTable(newEntryArray(initialCapacity));
      }
      
      AtomicReferenceArray<E> newEntryArray(int size)
      {
        return new AtomicReferenceArray(size);
      }
      
      void setTable(AtomicReferenceArray<E> newTable)
      {
        threshold = ((int)(newTable.length() * loadFactor));
        table = newTable;
      }
      
      E getFirst(int hash)
      {
        AtomicReferenceArray<E> table = this.table;
        return (E)table.get(hash & table.length() - 1);
      }
      
      public E getEntry(Object key, int hash)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        if (count != 0) {
          for (E e = getFirst(hash); e != null; e = s.getNext(e)) {
            if (s.getHash(e) == hash)
            {
              K entryKey = s.getKey(e);
              if (entryKey != null) {
                if (s.equalKeys(entryKey, key)) {
                  return e;
                }
              }
            }
          }
        }
        return null;
      }
      
      V get(Object key, int hash)
      {
        E entry = getEntry(key, hash);
        if (entry == null) {
          return null;
        }
        return (V)strategy.getValue(entry);
      }
      
      boolean containsKey(Object key, int hash)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        if (count != 0) {
          for (E e = getFirst(hash); e != null; e = s.getNext(e)) {
            if (s.getHash(e) == hash)
            {
              K entryKey = s.getKey(e);
              if (entryKey != null) {
                if (s.equalKeys(entryKey, key)) {
                  return s.getValue(e) != null;
                }
              }
            }
          }
        }
        return false;
      }
      
      boolean containsValue(Object value)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        if (count != 0)
        {
          AtomicReferenceArray<E> table = this.table;
          int length = table.length();
          for (int i = 0; i < length; i++) {
            for (E e = table.get(i); e != null; e = s.getNext(e))
            {
              V entryValue = s.getValue(e);
              if (entryValue != null) {
                if (s.equalValues(entryValue, value)) {
                  return true;
                }
              }
            }
          }
        }
        return false;
      }
      
      boolean replace(K key, int hash, V oldValue, V newValue)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        lock();
        try
        {
          for (E e = getFirst(hash); e != null; e = s.getNext(e))
          {
            K entryKey = s.getKey(e);
            if ((s.getHash(e) == hash) && (entryKey != null) && (s.equalKeys(key, entryKey)))
            {
              V entryValue = s.getValue(e);
              boolean bool;
              if (entryValue == null) {
                return false;
              }
              if (s.equalValues(entryValue, oldValue))
              {
                s.setValue(e, newValue);
                return true;
              }
            }
          }
          return 0;
        }
        finally
        {
          unlock();
        }
      }
      
      V replace(K key, int hash, V newValue)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        lock();
        try
        {
          for (E e = getFirst(hash); e != null; e = s.getNext(e))
          {
            K entryKey = s.getKey(e);
            if ((s.getHash(e) == hash) && (entryKey != null) && (s.equalKeys(key, entryKey)))
            {
              V entryValue = s.getValue(e);
              V ?;
              if (entryValue == null) {
                return null;
              }
              s.setValue(e, newValue);
              return entryValue;
            }
          }
          return null;
        }
        finally
        {
          unlock();
        }
      }
      
      V put(K key, int hash, V value, boolean onlyIfAbsent)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        lock();
        try
        {
          int count = this.count;
          if (count++ > threshold) {
            expand();
          }
          AtomicReferenceArray<E> table = this.table;
          int index = hash & table.length() - 1;
          
          E first = table.get(index);
          K entryKey;
          for (E e = first; e != null; e = s.getNext(e))
          {
            entryKey = s.getKey(e);
            if ((s.getHash(e) == hash) && (entryKey != null) && (s.equalKeys(key, entryKey)))
            {
              V entryValue = s.getValue(e);
              V ?;
              if ((onlyIfAbsent) && (entryValue != null)) {
                return entryValue;
              }
              s.setValue(e, value);
              return entryValue;
            }
          }
          modCount += 1;
          E newEntry = s.newEntry(key, hash, first);
          s.setValue(newEntry, value);
          table.set(index, newEntry);
          this.count = count;
          return null;
        }
        finally
        {
          unlock();
        }
      }
      
      void expand()
      {
        AtomicReferenceArray<E> oldTable = table;
        int oldCapacity = oldTable.length();
        if (oldCapacity >= 1073741824) {
          return;
        }
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        AtomicReferenceArray<E> newTable = newEntryArray(oldCapacity << 1);
        threshold = ((int)(newTable.length() * loadFactor));
        int newMask = newTable.length() - 1;
        for (int oldIndex = 0; oldIndex < oldCapacity; oldIndex++)
        {
          E head = oldTable.get(oldIndex);
          if (head != null)
          {
            E next = s.getNext(head);
            int headIndex = s.getHash(head) & newMask;
            if (next == null)
            {
              newTable.set(headIndex, head);
            }
            else
            {
              E tail = head;
              int tailIndex = headIndex;
              for (E last = next; last != null; last = s.getNext(last))
              {
                int newIndex = s.getHash(last) & newMask;
                if (newIndex != tailIndex)
                {
                  tailIndex = newIndex;
                  tail = last;
                }
              }
              newTable.set(tailIndex, tail);
              for (E e = head; e != tail; e = s.getNext(e))
              {
                K key = s.getKey(e);
                if (key != null)
                {
                  int newIndex = s.getHash(e) & newMask;
                  E newNext = newTable.get(newIndex);
                  newTable.set(newIndex, s.copyEntry(key, e, newNext));
                }
              }
            }
          }
        }
        table = newTable;
      }
      
      V remove(Object key, int hash)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        lock();
        try
        {
          int count = this.count - 1;
          AtomicReferenceArray<E> table = this.table;
          int index = hash & table.length() - 1;
          E first = table.get(index);
          for (E e = first; e != null; e = s.getNext(e))
          {
            K entryKey = s.getKey(e);
            if ((s.getHash(e) == hash) && (entryKey != null) && (s.equalKeys(entryKey, key)))
            {
              V entryValue = strategy.getValue(e);
              
              modCount += 1;
              E newFirst = s.getNext(e);
              for (E p = first; p != e; p = s.getNext(p))
              {
                K pKey = s.getKey(p);
                if (pKey != null) {
                  newFirst = s.copyEntry(pKey, p, newFirst);
                }
              }
              table.set(index, newFirst);
              this.count = count;
              return entryValue;
            }
          }
          return null;
        }
        finally
        {
          unlock();
        }
      }
      
      boolean remove(Object key, int hash, Object value)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        lock();
        try
        {
          int count = this.count - 1;
          AtomicReferenceArray<E> table = this.table;
          int index = hash & table.length() - 1;
          E first = table.get(index);
          for (E e = first; e != null; e = s.getNext(e))
          {
            K entryKey = s.getKey(e);
            if ((s.getHash(e) == hash) && (entryKey != null) && (s.equalKeys(entryKey, key)))
            {
              V entryValue = strategy.getValue(e);
              E newFirst;
              if ((value == entryValue) || ((value != null) && (entryValue != null) && (s.equalValues(entryValue, value))))
              {
                modCount += 1;
                newFirst = s.getNext(e);
                for (E p = first; p != e; p = s.getNext(p))
                {
                  K pKey = s.getKey(p);
                  if (pKey != null) {
                    newFirst = s.copyEntry(pKey, p, newFirst);
                  }
                }
                table.set(index, newFirst);
                this.count = count;
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
        }
      }
      
      public boolean removeEntry(E entry, int hash, V value)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        lock();
        try
        {
          int count = this.count - 1;
          AtomicReferenceArray<E> table = this.table;
          int index = hash & table.length() - 1;
          E first = table.get(index);
          for (E e = first; e != null; e = s.getNext(e)) {
            if ((s.getHash(e) == hash) && (entry.equals(e)))
            {
              V entryValue = s.getValue(e);
              E newFirst;
              if ((entryValue == value) || ((value != null) && (s.equalValues(entryValue, value))))
              {
                modCount += 1;
                newFirst = s.getNext(e);
                for (E p = first; p != e; p = s.getNext(p))
                {
                  K pKey = s.getKey(p);
                  if (pKey != null) {
                    newFirst = s.copyEntry(pKey, p, newFirst);
                  }
                }
                table.set(index, newFirst);
                this.count = count;
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
        }
      }
      
      public boolean removeEntry(E entry, int hash)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        lock();
        try
        {
          int count = this.count - 1;
          AtomicReferenceArray<E> table = this.table;
          int index = hash & table.length() - 1;
          E first = table.get(index);
          for (E e = first; e != null; e = s.getNext(e)) {
            if ((s.getHash(e) == hash) && (entry.equals(e)))
            {
              modCount += 1;
              E newFirst = s.getNext(e);
              for (E p = first; p != e; p = s.getNext(p))
              {
                K pKey = s.getKey(p);
                if (pKey != null) {
                  newFirst = s.copyEntry(pKey, p, newFirst);
                }
              }
              table.set(index, newFirst);
              this.count = count;
              return 1;
            }
          }
          return 0;
        }
        finally
        {
          unlock();
        }
      }
      
      void clear()
      {
        if (count != 0)
        {
          lock();
          try
          {
            AtomicReferenceArray<E> table = this.table;
            for (int i = 0; i < table.length(); i++) {
              table.set(i, null);
            }
            modCount += 1;
            count = 0;
          }
          finally
          {
            unlock();
          }
        }
      }
    }
    
    public boolean isEmpty()
    {
      Impl<K, V, E>[].Segment segments = this.segments;
      
      int[] mc = new int[segments.length];
      int mcsum = 0;
      for (int i = 0; i < segments.length; i++)
      {
        if (count != 0) {
          return false;
        }
        mcsum += (mc[i] = modCount);
      }
      if (mcsum != 0) {
        for (int i = 0; i < segments.length; i++) {
          if ((count != 0) || (mc[i] != modCount)) {
            return false;
          }
        }
      }
      return true;
    }
    
    public int size()
    {
      Impl<K, V, E>[].Segment segments = this.segments;
      long sum = 0L;
      long check = 0L;
      int[] mc = new int[segments.length];
      for (int k = 0; k < 2; k++)
      {
        check = 0L;
        sum = 0L;
        int mcsum = 0;
        for (int i = 0; i < segments.length; i++)
        {
          sum += count;
          mcsum += (mc[i] = modCount);
        }
        if (mcsum != 0) {
          for (int i = 0; i < segments.length; i++)
          {
            check += count;
            if (mc[i] != modCount)
            {
              check = -1L;
              break;
            }
          }
        }
        if (check == sum) {
          break;
        }
      }
      if (check != sum)
      {
        sum = 0L;
        for (Impl<K, V, E>.Segment segment : segments) {
          segment.lock();
        }
        for (Impl<K, V, E>.Segment segment : segments) {
          sum += count;
        }
        for (Impl<K, V, E>.Segment segment : segments) {
          segment.unlock();
        }
      }
      if (sum > 2147483647L) {
        return Integer.MAX_VALUE;
      }
      return (int)sum;
    }
    
    public V get(Object key)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      int hash = hash(key);
      return (V)segmentFor(hash).get(key, hash);
    }
    
    public boolean containsKey(Object key)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      int hash = hash(key);
      return segmentFor(hash).containsKey(key, hash);
    }
    
    public boolean containsValue(Object value)
    {
      if (value == null) {
        throw new NullPointerException("value");
      }
      Impl<K, V, E>[].Segment segments = this.segments;
      int[] mc = new int[segments.length];
      for (int k = 0; k < 2; k++)
      {
        int mcsum = 0;
        for (int i = 0; i < segments.length; i++)
        {
          int c = count;
          mcsum += (mc[i] = modCount);
          if (segments[i].containsValue(value)) {
            return true;
          }
        }
        boolean cleanSweep = true;
        if (mcsum != 0) {
          for (int i = 0; i < segments.length; i++)
          {
            int c = count;
            if (mc[i] != modCount)
            {
              cleanSweep = false;
              break;
            }
          }
        }
        if (cleanSweep) {
          return false;
        }
      }
      for (Impl<K, V, E>.Segment segment : segments) {
        segment.lock();
      }
      boolean found = false;
      try
      {
        for (Impl<K, V, E>.Segment segment : segments) {
          if (segment.containsValue(value))
          {
            found = true;
            break;
          }
        }
      }
      finally
      {
        Segment[] arr$;
        int len$;
        int i$;
        Impl<K, V, E>.Segment segment;
        for (Impl<K, V, E>.Segment segment : segments) {
          segment.unlock();
        }
      }
      return found;
    }
    
    public V put(K key, V value)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      if (value == null) {
        throw new NullPointerException("value");
      }
      int hash = hash(key);
      return (V)segmentFor(hash).put(key, hash, value, false);
    }
    
    public V putIfAbsent(K key, V value)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      if (value == null) {
        throw new NullPointerException("value");
      }
      int hash = hash(key);
      return (V)segmentFor(hash).put(key, hash, value, true);
    }
    
    public void putAll(Map<? extends K, ? extends V> m)
    {
      for (Map.Entry<? extends K, ? extends V> e : m.entrySet()) {
        put(e.getKey(), e.getValue());
      }
    }
    
    public V remove(Object key)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      int hash = hash(key);
      return (V)segmentFor(hash).remove(key, hash);
    }
    
    public boolean remove(Object key, Object value)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      int hash = hash(key);
      return segmentFor(hash).remove(key, hash, value);
    }
    
    public boolean replace(K key, V oldValue, V newValue)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      if (oldValue == null) {
        throw new NullPointerException("oldValue");
      }
      if (newValue == null) {
        throw new NullPointerException("newValue");
      }
      int hash = hash(key);
      return segmentFor(hash).replace(key, hash, oldValue, newValue);
    }
    
    public V replace(K key, V value)
    {
      if (key == null) {
        throw new NullPointerException("key");
      }
      if (value == null) {
        throw new NullPointerException("value");
      }
      int hash = hash(key);
      return (V)segmentFor(hash).replace(key, hash, value);
    }
    
    public void clear()
    {
      for (Impl<K, V, E>.Segment segment : segments) {
        segment.clear();
      }
    }
    
    public Set<K> keySet()
    {
      Set<K> ks = keySet;
      return ks != null ? ks : (keySet = new KeySet());
    }
    
    public Collection<V> values()
    {
      Collection<V> vs = values;
      return vs != null ? vs : (values = new Values());
    }
    
    public Set<Map.Entry<K, V>> entrySet()
    {
      Set<Map.Entry<K, V>> es = entrySet;
      return es != null ? es : (entrySet = new EntrySet());
    }
    
    abstract class HashIterator
    {
      int nextSegmentIndex;
      int nextTableIndex;
      AtomicReferenceArray<E> currentTable;
      E nextEntry;
      .CustomConcurrentHashMap.Impl<K, V, E>.WriteThroughEntry nextExternal;
      .CustomConcurrentHashMap.Impl<K, V, E>.WriteThroughEntry lastReturned;
      
      HashIterator()
      {
        nextSegmentIndex = (segments.length - 1);
        nextTableIndex = -1;
        advance();
      }
      
      public boolean hasMoreElements()
      {
        return hasNext();
      }
      
      final void advance()
      {
        nextExternal = null;
        if (nextInChain()) {
          return;
        }
        if (nextInTable()) {
          return;
        }
        while (nextSegmentIndex >= 0)
        {
          .CustomConcurrentHashMap.Impl<K, V, E>.Segment seg = segments[(nextSegmentIndex--)];
          if (count != 0)
          {
            currentTable = table;
            nextTableIndex = (currentTable.length() - 1);
            if (nextInTable()) {
              return;
            }
          }
        }
      }
      
      boolean nextInChain()
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        if (nextEntry != null) {
          for (nextEntry = s.getNext(nextEntry); nextEntry != null; nextEntry = s.getNext(nextEntry)) {
            if (advanceTo(nextEntry)) {
              return true;
            }
          }
        }
        return false;
      }
      
      boolean nextInTable()
      {
        while (nextTableIndex >= 0) {
          if (((nextEntry = currentTable.get(nextTableIndex--)) != null) && (
            (advanceTo(nextEntry)) || (nextInChain()))) {
            return true;
          }
        }
        return false;
      }
      
      boolean advanceTo(E entry)
      {
        .CustomConcurrentHashMap.Strategy<K, V, E> s = strategy;
        K key = s.getKey(entry);
        V value = s.getValue(entry);
        if ((key != null) && (value != null))
        {
          nextExternal = new .CustomConcurrentHashMap.Impl.WriteThroughEntry(.CustomConcurrentHashMap.Impl.this, key, value);
          return true;
        }
        return false;
      }
      
      public boolean hasNext()
      {
        return nextExternal != null;
      }
      
      .CustomConcurrentHashMap.Impl<K, V, E>.WriteThroughEntry nextEntry()
      {
        if (nextExternal == null) {
          throw new NoSuchElementException();
        }
        lastReturned = nextExternal;
        advance();
        return lastReturned;
      }
      
      public void remove()
      {
        if (lastReturned == null) {
          throw new IllegalStateException();
        }
        remove(lastReturned.getKey());
        lastReturned = null;
      }
    }
    
    final class KeyIterator
      extends .CustomConcurrentHashMap.Impl<K, V, E>.HashIterator
      implements Iterator<K>
    {
      KeyIterator()
      {
        super();
      }
      
      public K next()
      {
        return (K)super.nextEntry().getKey();
      }
    }
    
    final class ValueIterator
      extends .CustomConcurrentHashMap.Impl<K, V, E>.HashIterator
      implements Iterator<V>
    {
      ValueIterator()
      {
        super();
      }
      
      public V next()
      {
        return (V)super.nextEntry().getValue();
      }
    }
    
    final class WriteThroughEntry
      extends .AbstractMapEntry<K, V>
    {
      final K key;
      V value;
      
      WriteThroughEntry(V key)
      {
        this.key = key;
        this.value = value;
      }
      
      public K getKey()
      {
        return (K)key;
      }
      
      public V getValue()
      {
        return (V)value;
      }
      
      public V setValue(V value)
      {
        if (value == null) {
          throw new NullPointerException();
        }
        V oldValue = put(getKey(), value);
        this.value = value;
        return oldValue;
      }
    }
    
    final class EntryIterator
      extends .CustomConcurrentHashMap.Impl<K, V, E>.HashIterator
      implements Iterator<Map.Entry<K, V>>
    {
      EntryIterator()
      {
        super();
      }
      
      public Map.Entry<K, V> next()
      {
        return nextEntry();
      }
    }
    
    final class KeySet
      extends AbstractSet<K>
    {
      KeySet() {}
      
      public Iterator<K> iterator()
      {
        return new .CustomConcurrentHashMap.Impl.KeyIterator(.CustomConcurrentHashMap.Impl.this);
      }
      
      public int size()
      {
        return .CustomConcurrentHashMap.Impl.this.size();
      }
      
      public boolean isEmpty()
      {
        return .CustomConcurrentHashMap.Impl.this.isEmpty();
      }
      
      public boolean contains(Object o)
      {
        return containsKey(o);
      }
      
      public boolean remove(Object o)
      {
        return remove(o) != null;
      }
      
      public void clear()
      {
        .CustomConcurrentHashMap.Impl.this.clear();
      }
    }
    
    final class Values
      extends AbstractCollection<V>
    {
      Values() {}
      
      public Iterator<V> iterator()
      {
        return new .CustomConcurrentHashMap.Impl.ValueIterator(.CustomConcurrentHashMap.Impl.this);
      }
      
      public int size()
      {
        return .CustomConcurrentHashMap.Impl.this.size();
      }
      
      public boolean isEmpty()
      {
        return .CustomConcurrentHashMap.Impl.this.isEmpty();
      }
      
      public boolean contains(Object o)
      {
        return containsValue(o);
      }
      
      public void clear()
      {
        .CustomConcurrentHashMap.Impl.this.clear();
      }
    }
    
    final class EntrySet
      extends AbstractSet<Map.Entry<K, V>>
    {
      EntrySet() {}
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        return new .CustomConcurrentHashMap.Impl.EntryIterator(.CustomConcurrentHashMap.Impl.this);
      }
      
      public boolean contains(Object o)
      {
        if (!(o instanceof Map.Entry)) {
          return false;
        }
        Map.Entry<?, ?> e = (Map.Entry)o;
        Object key = e.getKey();
        if (key == null) {
          return false;
        }
        V v = get(key);
        
        return (v != null) && (strategy.equalValues(v, e.getValue()));
      }
      
      public boolean remove(Object o)
      {
        if (!(o instanceof Map.Entry)) {
          return false;
        }
        Map.Entry<?, ?> e = (Map.Entry)o;
        Object key = e.getKey();
        return (key != null) && (remove(key, e.getValue()));
      }
      
      public int size()
      {
        return .CustomConcurrentHashMap.Impl.this.size();
      }
      
      public boolean isEmpty()
      {
        return .CustomConcurrentHashMap.Impl.this.isEmpty();
      }
      
      public void clear()
      {
        .CustomConcurrentHashMap.Impl.this.clear();
      }
    }
    
    private void writeObject(ObjectOutputStream out)
      throws IOException
    {
      out.writeInt(size());
      out.writeFloat(loadFactor);
      out.writeInt(segments.length);
      out.writeObject(strategy);
      for (Map.Entry<K, V> entry : entrySet())
      {
        out.writeObject(entry.getKey());
        out.writeObject(entry.getValue());
      }
      out.writeObject(null);
    }
    
    static class Fields
    {
      static final Field loadFactor = findField("loadFactor");
      static final Field segmentShift = findField("segmentShift");
      static final Field segmentMask = findField("segmentMask");
      static final Field segments = findField("segments");
      static final Field strategy = findField("strategy");
      
      static Field findField(String name)
      {
        try
        {
          Field f = .CustomConcurrentHashMap.Impl.class.getDeclaredField(name);
          f.setAccessible(true);
          return f;
        }
        catch (NoSuchFieldException e)
        {
          throw new AssertionError(e);
        }
      }
    }
    
    private void readObject(ObjectInputStream in)
      throws IOException, ClassNotFoundException
    {
      try
      {
        int initialCapacity = in.readInt();
        float loadFactor = in.readFloat();
        int concurrencyLevel = in.readInt();
        .CustomConcurrentHashMap.Strategy<K, V, E> strategy = (.CustomConcurrentHashMap.Strategy)in.readObject();
        
        Fields.loadFactor.set(this, Float.valueOf(loadFactor));
        if (concurrencyLevel > 65536) {
          concurrencyLevel = 65536;
        }
        int segmentShift = 0;
        int segmentCount = 1;
        while (segmentCount < concurrencyLevel)
        {
          segmentShift++;
          segmentCount <<= 1;
        }
        Fields.segmentShift.set(this, Integer.valueOf(32 - segmentShift));
        Fields.segmentMask.set(this, Integer.valueOf(segmentCount - 1));
        Fields.segments.set(this, newSegmentArray(segmentCount));
        if (initialCapacity > 1073741824) {
          initialCapacity = 1073741824;
        }
        int segmentCapacity = initialCapacity / segmentCount;
        if (segmentCapacity * segmentCount < initialCapacity) {
          segmentCapacity++;
        }
        int segmentSize = 1;
        while (segmentSize < segmentCapacity) {
          segmentSize <<= 1;
        }
        for (int i = 0; i < segments.length; i++) {
          segments[i] = new Segment(segmentSize);
        }
        Fields.strategy.set(this, strategy);
        for (;;)
        {
          K key = in.readObject();
          if (key == null) {
            break;
          }
          V value = in.readObject();
          put(key, value);
        }
      }
      catch (IllegalAccessException e)
      {
        throw new AssertionError(e);
      }
    }
  }
  
  static class ComputingImpl<K, V, E>
    extends .CustomConcurrentHashMap.Impl<K, V, E>
  {
    static final long serialVersionUID = 0L;
    final .CustomConcurrentHashMap.ComputingStrategy<K, V, E> computingStrategy;
    final .Function<? super K, ? extends V> computer;
    
    ComputingImpl(.CustomConcurrentHashMap.ComputingStrategy<K, V, E> strategy, .CustomConcurrentHashMap.Builder builder, .Function<? super K, ? extends V> computer)
    {
      super(builder);
      computingStrategy = strategy;
      this.computer = computer;
    }
    
    public V get(Object k)
    {
      K key = (K)k;
      if (key == null) {
        throw new NullPointerException("key");
      }
      int hash = hash(key);
      .CustomConcurrentHashMap.Impl<K, V, E>.Segment segment = segmentFor(hash);
      for (;;)
      {
        E entry = segment.getEntry(key, hash);
        V value;
        if (entry == null)
        {
          boolean created = false;
          segment.lock();
          int index;
          try
          {
            entry = segment.getEntry(key, hash);
            if (entry == null)
            {
              created = true;
              int count = count;
              if (count++ > threshold) {
                segment.expand();
              }
              AtomicReferenceArray<E> table = table;
              index = hash & table.length() - 1;
              E first = table.get(index);
              modCount += 1;
              entry = computingStrategy.newEntry(key, hash, first);
              table.set(index, entry);
              count = count;
            }
          }
          finally
          {
            segment.unlock();
          }
          if (created)
          {
            boolean success = false;
            try
            {
              value = computingStrategy.compute(key, entry, computer);
              if (value == null) {
                throw new NullPointerException("compute() returned null unexpectedly");
              }
              success = true;
              return value;
            }
            finally
            {
              if (!success) {
                segment.removeEntry(entry, hash);
              }
            }
          }
        }
        boolean interrupted = false;
        try
        {
          V value = computingStrategy.waitForValue(entry);
          if (value == null)
          {
            segment.removeEntry(entry, hash);
            if (!interrupted) {
              continue;
            }
            Thread.currentThread().interrupt(); continue;
          }
          return value;
        }
        catch (InterruptedException e)
        {
          for (;;)
          {
            interrupted = true;
          }
        }
        finally
        {
          if (interrupted) {
            Thread.currentThread().interrupt();
          }
        }
      }
    }
  }
  
  static class SimpleStrategy<K, V>
    implements .CustomConcurrentHashMap.Strategy<K, V, .CustomConcurrentHashMap.SimpleInternalEntry<K, V>>
  {
    public .CustomConcurrentHashMap.SimpleInternalEntry<K, V> newEntry(K key, int hash, .CustomConcurrentHashMap.SimpleInternalEntry<K, V> next)
    {
      return new .CustomConcurrentHashMap.SimpleInternalEntry(key, hash, null, next);
    }
    
    public .CustomConcurrentHashMap.SimpleInternalEntry<K, V> copyEntry(K key, .CustomConcurrentHashMap.SimpleInternalEntry<K, V> original, .CustomConcurrentHashMap.SimpleInternalEntry<K, V> next)
    {
      return new .CustomConcurrentHashMap.SimpleInternalEntry(key, hash, value, next);
    }
    
    public void setValue(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry, V value)
    {
      value = value;
    }
    
    public V getValue(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
    {
      return (V)value;
    }
    
    public boolean equalKeys(K a, Object b)
    {
      return a.equals(b);
    }
    
    public boolean equalValues(V a, Object b)
    {
      return a.equals(b);
    }
    
    public int hashKey(Object key)
    {
      return key.hashCode();
    }
    
    public K getKey(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
    {
      return (K)key;
    }
    
    public .CustomConcurrentHashMap.SimpleInternalEntry<K, V> getNext(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
    {
      return next;
    }
    
    public int getHash(.CustomConcurrentHashMap.SimpleInternalEntry<K, V> entry)
    {
      return hash;
    }
    
    public void setInternals(.CustomConcurrentHashMap.Internals<K, V, .CustomConcurrentHashMap.SimpleInternalEntry<K, V>> internals) {}
  }
  
  static class SimpleInternalEntry<K, V>
  {
    final K key;
    final int hash;
    final SimpleInternalEntry<K, V> next;
    volatile V value;
    
    SimpleInternalEntry(K key, int hash, @.Nullable V value, SimpleInternalEntry<K, V> next)
    {
      this.key = key;
      this.hash = hash;
      this.value = value;
      this.next = next;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */