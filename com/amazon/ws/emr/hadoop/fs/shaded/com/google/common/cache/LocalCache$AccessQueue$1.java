package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

class LocalCache$AccessQueue$1
  extends LocalCache.AbstractReferenceEntry<K, V>
{
  LocalCache$AccessQueue$1(LocalCache.AccessQueue paramAccessQueue) {}
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.AccessQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */