package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicReferenceArray;

abstract class MapMakerInternalMap$HashIterator<E>
  implements Iterator<E>
{
  int nextSegmentIndex;
  int nextTableIndex;
  MapMakerInternalMap.Segment<K, V> currentSegment;
  AtomicReferenceArray<MapMakerInternalMap.ReferenceEntry<K, V>> currentTable;
  MapMakerInternalMap.ReferenceEntry<K, V> nextEntry;
  MapMakerInternalMap<K, V>.WriteThroughEntry nextExternal;
  MapMakerInternalMap<K, V>.WriteThroughEntry lastReturned;
  
  MapMakerInternalMap$HashIterator(MapMakerInternalMap paramMapMakerInternalMap)
  {
    nextSegmentIndex = (segments.length - 1);
    nextTableIndex = -1;
    advance();
  }
  
  public abstract E next();
  
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
      if (((nextEntry = (MapMakerInternalMap.ReferenceEntry)currentTable.get(nextTableIndex--)) != null) && (
        (advanceTo(nextEntry)) || (nextInChain()))) {
        return true;
      }
    }
    return false;
  }
  
  boolean advanceTo(MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    try
    {
      K key = entry.getKey();
      V value = this$0.getLiveValue(entry);
      boolean bool;
      if (value != null)
      {
        nextExternal = new MapMakerInternalMap.WriteThroughEntry(this$0, key, value);
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
  
  MapMakerInternalMap<K, V>.WriteThroughEntry nextEntry()
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
    CollectPreconditions.checkRemove(lastReturned != null);
    this$0.remove(lastReturned.getKey());
    lastReturned = null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.HashIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */