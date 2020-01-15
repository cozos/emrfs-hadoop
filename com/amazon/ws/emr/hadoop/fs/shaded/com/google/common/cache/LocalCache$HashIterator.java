package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Ticker;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class LocalCache$HashIterator<T>
  implements Iterator<T>
{
  int nextSegmentIndex;
  int nextTableIndex;
  LocalCache.Segment<K, V> currentSegment;
  AtomicReferenceArray<LocalCache.ReferenceEntry<K, V>> currentTable;
  LocalCache.ReferenceEntry<K, V> nextEntry;
  LocalCache<K, V>.WriteThroughEntry nextExternal;
  LocalCache<K, V>.WriteThroughEntry lastReturned;
  
  LocalCache$HashIterator(LocalCache paramLocalCache)
  {
    nextSegmentIndex = (segments.length - 1);
    nextTableIndex = -1;
    advance();
  }
  
  public abstract T next();
  
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
      currentSegment = this$0.segments[(nextSegmentIndex--)];
      if (currentSegment.count != 0)
      {
        currentTable = currentSegment.table;
        nextTableIndex = (currentTable.length() - 1);
        if (nextInTable()) {}
      }
    }
  }
  
  boolean nextInChain()
  {
    if (nextEntry != null) {
      for (nextEntry = nextEntry.getNext(); nextEntry != null; nextEntry = nextEntry.getNext()) {
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
      if (((nextEntry = (LocalCache.ReferenceEntry)currentTable.get(nextTableIndex--)) != null) && (
        (advanceTo(nextEntry)) || (nextInChain()))) {
        return true;
      }
    }
    return false;
  }
  
  boolean advanceTo(LocalCache.ReferenceEntry<K, V> entry)
  {
    try
    {
      long now = this$0.ticker.read();
      K key = entry.getKey();
      V value = this$0.getLiveValue(entry, now);
      boolean bool;
      if (value != null)
      {
        nextExternal = new LocalCache.WriteThroughEntry(this$0, key, value);
        return true;
      }
      return false;
    }
    finally
    {
      currentSegment.postReadCleanup();
    }
  }
  
  public boolean hasNext()
  {
    return nextExternal != null;
  }
  
  LocalCache<K, V>.WriteThroughEntry nextEntry()
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
    Preconditions.checkState(lastReturned != null);
    this$0.remove(lastReturned.getKey());
    lastReturned = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.HashIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */