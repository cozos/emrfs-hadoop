package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractQueue;
import java.util.Iterator;

final class MapMakerInternalMap$ExpirationQueue<K, V>
  extends AbstractQueue<MapMakerInternalMap.ReferenceEntry<K, V>>
{
  final MapMakerInternalMap.ReferenceEntry<K, V> head = new MapMakerInternalMap.AbstractReferenceEntry()
  {
    public long getExpirationTime()
    {
      return Long.MAX_VALUE;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> nextExpirable = this;
    
    public void setExpirationTime(long time) {}
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getNextExpirable()
    {
      return nextExpirable;
    }
    
    public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<K, V> next)
    {
      nextExpirable = next;
    }
    
    MapMakerInternalMap.ReferenceEntry<K, V> previousExpirable = this;
    
    public MapMakerInternalMap.ReferenceEntry<K, V> getPreviousExpirable()
    {
      return previousExpirable;
    }
    
    public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<K, V> previous)
    {
      previousExpirable = previous;
    }
  };
  
  public boolean offer(MapMakerInternalMap.ReferenceEntry<K, V> entry)
  {
    MapMakerInternalMap.connectExpirables(entry.getPreviousExpirable(), entry.getNextExpirable());
    
    MapMakerInternalMap.connectExpirables(head.getPreviousExpirable(), entry);
    MapMakerInternalMap.connectExpirables(entry, head);
    
    return true;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> peek()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextExpirable();
    return next == head ? null : next;
  }
  
  public MapMakerInternalMap.ReferenceEntry<K, V> poll()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> next = head.getNextExpirable();
    if (next == head) {
      return null;
    }
    remove(next);
    return next;
  }
  
  public boolean remove(Object o)
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
    MapMakerInternalMap.ReferenceEntry<K, V> previous = e.getPreviousExpirable();
    MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextExpirable();
    MapMakerInternalMap.connectExpirables(previous, next);
    MapMakerInternalMap.nullifyExpirable(e);
    
    return next != MapMakerInternalMap.NullEntry.INSTANCE;
  }
  
  public boolean contains(Object o)
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e = (MapMakerInternalMap.ReferenceEntry)o;
    return e.getNextExpirable() != MapMakerInternalMap.NullEntry.INSTANCE;
  }
  
  public boolean isEmpty()
  {
    return head.getNextExpirable() == head;
  }
  
  public int size()
  {
    int size = 0;
    for (MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextExpirable(); e != head; e = e.getNextExpirable()) {
      size++;
    }
    return size;
  }
  
  public void clear()
  {
    MapMakerInternalMap.ReferenceEntry<K, V> e = head.getNextExpirable();
    while (e != head)
    {
      MapMakerInternalMap.ReferenceEntry<K, V> next = e.getNextExpirable();
      MapMakerInternalMap.nullifyExpirable(e);
      e = next;
    }
    head.setNextExpirable(head);
    head.setPreviousExpirable(head);
  }
  
  public Iterator<MapMakerInternalMap.ReferenceEntry<K, V>> iterator()
  {
    new AbstractSequentialIterator(peek())
    {
      protected MapMakerInternalMap.ReferenceEntry<K, V> computeNext(MapMakerInternalMap.ReferenceEntry<K, V> previous)
      {
        MapMakerInternalMap.ReferenceEntry<K, V> next = previous.getNextExpirable();
        return next == head ? null : next;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.ExpirationQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */