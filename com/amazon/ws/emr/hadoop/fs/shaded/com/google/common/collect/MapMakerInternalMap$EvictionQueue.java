package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

final class MapMakerInternalMap$EvictionQueue<K, V>
  extends AbstractQueue<MapMakerInternalMap.ReferenceEntry<K, V>>
{
  final MapMakerInternalMap.ReferenceEntry<K, V> head = new MapMakerInternalMap.AbstractReferenceEntry()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> nextEvictable = this;
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextEvictable()
    {
      return nextEvictable;
    }
    
    public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextEvictable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousEvictable = this;
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousEvictable()
    {
      return previousEvictable;
    }
    
    public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousEvictable = previous;
    }
  };
  
  public boolean offer(MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    MapMakerInternalMap.connectEvictables(entry.getPreviousEvictable(), entry.getNextEvictable());
    
    MapMakerInternalMap.connectEvictables(head.getPreviousEvictable(), entry);
    MapMakerInternalMap.connectEvictables(entry, head);
    
    return true;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> peek()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextEvictable();
    return next == head ? null : next;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> poll()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextEvictable();
    if (next == head) {
      return null;
    }
    remove(next);
    return next;
  }
  
  public boolean remove(Object o)
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
    MapMakerInternalMap.ReferenceEntry<K, V> previous = e.getPreviousEvictable();
    MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextEvictable();
    MapMakerInternalMap.connectEvictables(previous, next);
    MapMakerInternalMap.nullifyEvictable(e);
    
    return next != MapMakerInternalMap.NullEntry.INSTANCE;
  }
  
  public boolean contains(Object o)
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
    return e.getNextEvictable() != MapMakerInternalMap.NullEntry.INSTANCE;
  }
  
  public boolean isEmpty()
  {
    return head.getNextEvictable() == head;
  }
  
  public int size()
  {
    int size = 0;
    for (MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextEvictable(); e != head; e = e.getNextEvictable()) {
      size++;
    }
    return size;
  }
  
  public void clear()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextEvictable();
    while (e != head)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextEvictable();
      MapMakerInternalMap.nullifyEvictable(e);
      e = next;
    }
    head.setNextEvictable(head);
    head.setPreviousEvictable(head);
  }
  
  public Iterator<MapMakerInternalMap.ReferenceEntry<K, V>> iterator()
  {
    new AbstractSequentialIterator(peek())
    {
      protected MapMakerInternalMap.ReferenceEntry<K, V> computeNext(MapMakerInternalMap.ReferenceEntry<K, V> previous)
      {
        MapMakerInternalMap.ReferenceEntry<K, V> next = previous.getNextEvictable();
        return next == head ? null : next;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.EvictionQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */