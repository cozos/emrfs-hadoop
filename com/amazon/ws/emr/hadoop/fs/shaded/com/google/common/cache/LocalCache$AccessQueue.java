package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractSequentialIterator;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$AccessQueue<K, V>
  extends AbstractQueue<LocalCache.ReferenceEntry<K, V>>
{
  final LocalCache.ReferenceEntry<K, V> head = new LocalCache.AbstractReferenceEntry()
  {
    public long getAccessTime()
    {
      return Long.MAX_VALUE;
    }
    
    LocalCache.ReferenceEntry<K, V> nextAccess = this;
    
    public void setAccessTime(long time) {}
    
    public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue()
    {
      return nextAccess;
    }
    
    public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> next)
    {
      nextAccess = next;
    }
    
    LocalCache.ReferenceEntry<K, V> previousAccess = this;
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue()
    {
      return previousAccess;
    }
    
    public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> previous)
    {
      previousAccess = previous;
    }
  };
  
  public boolean offer(LocalCache.ReferenceEntry<K, V> entry)
  {
    LocalCache.connectAccessOrder(entry.getPreviousInAccessQueue(), entry.getNextInAccessQueue());
    
    LocalCache.connectAccessOrder(head.getPreviousInAccessQueue(), entry);
    LocalCache.connectAccessOrder(entry, head);
    
    return true;
  }
  
  public LocalCache.ReferenceEntry<K, V> peek()
  {
    LocalCache.ReferenceEntry<K, V> next = head.getNextInAccessQueue();
    return next == head ? null : next;
  }
  
  public LocalCache.ReferenceEntry<K, V> poll()
  {
    LocalCache.ReferenceEntry<K, V> next = head.getNextInAccessQueue();
    if (next == head) {
      return null;
    }
    remove(next);
    return next;
  }
  
  public boolean remove(Object o)
  {
    LocalCache.ReferenceEntry<K, V> e = (LocalCache.ReferenceEntry)o;
    LocalCache.ReferenceEntry<K, V> previous = e.getPreviousInAccessQueue();
    LocalCache.ReferenceEntry<K, V> next = e.getNextInAccessQueue();
    LocalCache.connectAccessOrder(previous, next);
    LocalCache.nullifyAccessOrder(e);
    
    return next != LocalCache.NullEntry.INSTANCE;
  }
  
  public boolean contains(Object o)
  {
    LocalCache.ReferenceEntry<K, V> e = (LocalCache.ReferenceEntry)o;
    return e.getNextInAccessQueue() != LocalCache.NullEntry.INSTANCE;
  }
  
  public boolean isEmpty()
  {
    return head.getNextInAccessQueue() == head;
  }
  
  public int size()
  {
    int size = 0;
    for (LocalCache.ReferenceEntry<K, V> e = head.getNextInAccessQueue(); e != head; e = e.getNextInAccessQueue()) {
      size++;
    }
    return size;
  }
  
  public void clear()
  {
    LocalCache.ReferenceEntry<K, V> e = head.getNextInAccessQueue();
    while (e != head)
    {
      LocalCache.ReferenceEntry<K, V> next = e.getNextInAccessQueue();
      LocalCache.nullifyAccessOrder(e);
      e = next;
    }
    head.setNextInAccessQueue(head);
    head.setPreviousInAccessQueue(head);
  }
  
  public Iterator<LocalCache.ReferenceEntry<K, V>> iterator()
  {
    new AbstractSequentialIterator(peek())
    {
      protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> previous)
      {
        LocalCache.ReferenceEntry<K, V> next = previous.getNextInAccessQueue();
        return next == head ? null : next;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.AccessQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */