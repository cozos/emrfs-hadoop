package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import javax.annotation.Nullable;

class LocalCache$WeakEntry<K, V>
  extends WeakReference<K>
  implements LocalCache.ReferenceEntry<K, V>
{
  final int hash;
  final LocalCache.ReferenceEntry<K, V> next;
  
  LocalCache$WeakEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable LocalCache.ReferenceEntry<K, V> next)
  {
    super(key, queue);
    this.hash = hash;
    this.next = next;
  }
  
  public K getKey()
  {
    return (K)get();
  }
  
  public long getAccessTime()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setAccessTime(long time)
  {
    throw new UnsupportedOperationException();
  }
  
  public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> next)
  {
    throw new UnsupportedOperationException();
  }
  
  public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> previous)
  {
    throw new UnsupportedOperationException();
  }
  
  public long getWriteTime()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setWriteTime(long time)
  {
    throw new UnsupportedOperationException();
  }
  
  public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> next)
  {
    throw new UnsupportedOperationException();
  }
  
  public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue()
  {
    throw new UnsupportedOperationException();
  }
  
  public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> previous)
  {
    throw new UnsupportedOperationException();
  }
  
  volatile LocalCache.ValueReference<K, V> valueReference = LocalCache.unset();
  
  public LocalCache.ValueReference<K, V> getValueReference()
  {
    return valueReference;
  }
  
  public void setValueReference(LocalCache.ValueReference<K, V> valueReference)
  {
    this.valueReference = valueReference;
  }
  
  public int getHash()
  {
    return hash;
  }
  
  public LocalCache.ReferenceEntry<K, V> getNext()
  {
    return next;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WeakEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */