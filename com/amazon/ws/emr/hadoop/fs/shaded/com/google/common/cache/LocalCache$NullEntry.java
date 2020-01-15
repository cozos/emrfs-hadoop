package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

 enum LocalCache$NullEntry
  implements LocalCache.ReferenceEntry<Object, Object>
{
  INSTANCE;
  
  private LocalCache$NullEntry() {}
  
  public LocalCache.ValueReference<Object, Object> getValueReference()
  {
    return null;
  }
  
  public void setValueReference(LocalCache.ValueReference<Object, Object> valueReference) {}
  
  public LocalCache.ReferenceEntry<Object, Object> getNext()
  {
    return null;
  }
  
  public int getHash()
  {
    return 0;
  }
  
  public Object getKey()
  {
    return null;
  }
  
  public long getAccessTime()
  {
    return 0L;
  }
  
  public void setAccessTime(long time) {}
  
  public LocalCache.ReferenceEntry<Object, Object> getNextInAccessQueue()
  {
    return this;
  }
  
  public void setNextInAccessQueue(LocalCache.ReferenceEntry<Object, Object> next) {}
  
  public LocalCache.ReferenceEntry<Object, Object> getPreviousInAccessQueue()
  {
    return this;
  }
  
  public void setPreviousInAccessQueue(LocalCache.ReferenceEntry<Object, Object> previous) {}
  
  public long getWriteTime()
  {
    return 0L;
  }
  
  public void setWriteTime(long time) {}
  
  public LocalCache.ReferenceEntry<Object, Object> getNextInWriteQueue()
  {
    return this;
  }
  
  public void setNextInWriteQueue(LocalCache.ReferenceEntry<Object, Object> next) {}
  
  public LocalCache.ReferenceEntry<Object, Object> getPreviousInWriteQueue()
  {
    return this;
  }
  
  public void setPreviousInWriteQueue(LocalCache.ReferenceEntry<Object, Object> previous) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.NullEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */