package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

class LocalCache$WriteQueue$1
  extends LocalCache.AbstractReferenceEntry<K, V>
{
  LocalCache$WriteQueue$1(LocalCache.WriteQueue paramWriteQueue) {}
  
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
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.WriteQueue.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */