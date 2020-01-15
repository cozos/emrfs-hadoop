package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import javax.annotation.Nullable;

final class LocalCache$StrongAccessWriteEntry<K, V>
  extends LocalCache.StrongEntry<K, V>
{
  LocalCache$StrongAccessWriteEntry(K key, int hash, @Nullable LocalCache.ReferenceEntry<K, V> next)
  {
    super(key, hash, next);
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
  
  volatile long writeTime = Long.MAX_VALUE;
  
  public long getWriteTime()
  {
    return writeTime;
  }
  
  public void setWriteTime(long time)
  {
    writeTime = time;
  }
  
  LocalCache.ReferenceEntry<K, V> nextWrite = LocalCache.nullEntry();
  
  public LocalCache.ReferenceEntry<K, V> getNextInWriteQueue()
  {
    return nextWrite;
  }
  
  public void setNextInWriteQueue(LocalCache.ReferenceEntry<K, V> next)
  {
    nextWrite = next;
  }
  
  LocalCache.ReferenceEntry<K, V> previousWrite = LocalCache.nullEntry();
  
  public LocalCache.ReferenceEntry<K, V> getPreviousInWriteQueue()
  {
    return previousWrite;
  }
  
  public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<K, V> previous)
  {
    previousWrite = previous;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.StrongAccessWriteEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */