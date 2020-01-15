package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class $CustomConcurrentHashMap$Impl$HashIterator
{
  int nextSegmentIndex;
  int nextTableIndex;
  AtomicReferenceArray<E> currentTable;
  E nextEntry;
  .CustomConcurrentHashMap.Impl<K, V, E>.WriteThroughEntry nextExternal;
  .CustomConcurrentHashMap.Impl<K, V, E>.WriteThroughEntry lastReturned;
  
  $CustomConcurrentHashMap$Impl$HashIterator(.CustomConcurrentHashMap.Impl paramImpl)
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
      .CustomConcurrentHashMap.Impl<K, V, E>.Segment seg = this$0.segments[(nextSegmentIndex--)];
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
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
    .CustomConcurrentHashMap.Strategy<K, V, E> s = this$0.strategy;
    K key = s.getKey(entry);
    V value = s.getValue(entry);
    if ((key != null) && (value != null))
    {
      nextExternal = new .CustomConcurrentHashMap.Impl.WriteThroughEntry(this$0, key, value);
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
    this$0.remove(lastReturned.getKey());
    lastReturned = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.HashIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */