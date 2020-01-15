package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractSequentialIterator;
import java.util.AbstractQueue;
import java.util.Iterator;

final class LocalCache$WriteQueue<K, V>
  extends AbstractQueue<LocalCache.ReferenceEntry<K, V>>
{
  final LocalCache.ReferenceEntry<K, V> head = new LocalCache.AbstractReferenceEntry()
  {
    public long getWriteTime()
    {
      return Long.MAX_VALUE;
    }
    
    LocalCache.ReferenceEntry<K, V> nextWrite = this;
    
    public void setWriteTime(long time) {}
    
    public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue()
    {
      return nextWrite;
    }
    
    public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> next)
    {
      nextWrite = next;
    }
    
    LocalCache.ReferenceEntry<K, V> previousWrite = this;
    
    public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue()
    {
      return previousWrite;
    }
    
    public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> previous)
    {
      previousWrite = previous;
    }
  };
  
  public boolean offer(LocalCache.ReferenceEntry<K, V> entry)
  {
    LocalCache.connectWriteOrder(entry.getPreviousInWriteQueue(), entry.getNextInWriteQueue());
    
    LocalCache.connectWriteOrder(head.getPreviousInWriteQueue(), entry);
    LocalCache.connectWriteOrder(entry, head);
    
    return true;
  }
  
  public LocalCache.ReferenceEntry<K, V> peek()
  {
    LocalCache.ReferenceEntry<K, V> next = head.getNextInWriteQueue();
    return next == head ? null : next;
  }
  
  public LocalCache.ReferenceEntry<K, V> poll()
  {
    LocalCache.ReferenceEntry<K, V> next = head.getNextInWriteQueue();
    if (next == head) {
      return null;
    }
    remove(next);
    return next;
  }
  
  public boolean remove(Object o)
  {
    LocalCache.ReferenceEntry<K, V> e = (LocalCache.ReferenceEntry)o;
    LocalCache.ReferenceEntry<K, V> previous = e.getPreviousInWriteQueue();
    LocalCache.ReferenceEntry<K, V> next = e.getNextInWriteQueue();
    LocalCache.connectWriteOrder(previous, next);
    LocalCache.nullifyWriteOrder(e);
    
    return next != LocalCache.NullEntry.INSTANCE;
  }
  
  public boolean contains(Object o)
  {
    LocalCache.ReferenceEntry<K, V> e = (LocalCache.ReferenceEntry)o;
    return e.getNextInWriteQueue() != LocalCache.NullEntry.INSTANCE;
  }
  
  public boolean isEmpty()
  {
    return head.getNextInWriteQueue() == head;
  }
  
  public int size()
  {
    int size = 0;
    for (LocalCache.ReferenceEntry<K, V> e = head.getNextInWriteQueue(); e != head; e = e.getNextInWriteQueue()) {
      size++;
    }
    return size;
  }
  
  public void clear()
  {
    LocalCache.ReferenceEntry<K, V> e = head.getNextInWriteQueue();
    while (e != head)
    {
      LocalCache.ReferenceEntry<K, V> next = e.getNextInWriteQueue();
      LocalCache.nullifyWriteOrder(e);
      e = next;
    }
    head.setNextInWriteQueue(head);
    head.setPreviousInWriteQueue(head);
  }
  
  public Iterator<LocalCache.ReferenceEntry<K, V>> iterator()
  {
    new AbstractSequentialIterator(peek())
    {
      protected LocalCache.ReferenceEntry<K, V> computeNext(LocalCache.ReferenceEntry<K, V> previous)
      {
        LocalCache.ReferenceEntry<K, V> next = previous.getNextInWriteQueue();
        return next == head ? null : next;
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WriteQueue
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */