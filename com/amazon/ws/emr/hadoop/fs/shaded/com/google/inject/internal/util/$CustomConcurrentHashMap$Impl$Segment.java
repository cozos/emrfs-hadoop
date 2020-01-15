package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

final class $CustomConcurrentHashMap$Impl$Segment
  extends ReentrantLock
{
  volatile int count;
  int modCount;
  int threshold;
  volatile AtomicReferenceArray<E> table;
  
  $CustomConcurrentHashMap$Impl$Segment(.CustomConcurrentHashMap.Impl paramImpl, int initialCapacity)
  {
    setTable(newEntryArray(initialCapacity));
  }
  
  AtomicReferenceArray<E> newEntryArray(int size)
  {
    return new AtomicReferenceArray(size);
  }
  
  void setTable(AtomicReferenceArray<E> newTable)
  {
    threshold = ((int)(newTable.length() * this$0.loadFactor));
    table = newTable;
  }
  
  E getFirst(int hash)
  {
    AtomicReferenceArray<E> table = this.table;
    return (E)table.get(hash & table.length() - 1);
  }
  
  public E getEntry(Object key, int hash)
  {
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    return (V)this$0.strategy.getValue(entry);
  }
  
  boolean containsKey(Object key, int hash)
  {
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
    AtomicReferenceArray<E> newTable = newEntryArray(oldCapacity << 1);
    threshold = ((int)(newTable.length() * this$0.loadFactor));
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
          V entryValue = this$0.strategy.getValue(e);
          
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
          V entryValue = this$0.strategy.getValue(e);
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.Segment
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */