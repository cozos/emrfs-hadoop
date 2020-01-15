package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import java.lang.ref.ReferenceQueue;
import javax.annotation.Nullable;

final class LocalCache$WeakAccessEntry<K, V>
  extends LocalCache.WeakEntry<K, V>
{
  LocalCache$WeakAccessEntry(ReferenceQueue<K> queue, K key, int hash, @Nullable LocalCache.ReferenceEntry<K, V> next)
  {
    super(queue, key, hash, next);
  }
  
  volatile long accessTime = Long.MAX_VALUE;
  
  public long getAccessTime()
  {
    return accessTime;
  }
  
  public void setAccessTime(long time)
  {
    accessTime = time;
  }
  
  LocalCache.ReferenceEntry<K, V> nextAccess = LocalCache.nullEntry();
  
  public LocalCache.ReferenceEntry<K, V> getNextInAccessQueue()
  {
    return nextAccess;
  }
  
  public void setNextInAccessQueue(LocalCache.ReferenceEntry<K, V> next)
  {
    nextAccess = next;
  }
  
  LocalCache.ReferenceEntry<K, V> previousAccess = LocalCache.nullEntry();
  
  public LocalCache.ReferenceEntry<K, V> getPreviousInAccessQueue()
  {
    return previousAccess;
  }
  
  public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<K, V> previous)
  {
    previousAccess = previous;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WeakAccessEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */