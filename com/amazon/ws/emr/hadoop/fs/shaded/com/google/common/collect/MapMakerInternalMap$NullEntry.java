package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

 enum MapMakerInternalMap$NullEntry
  implements MapMakerInternalMap.ReferenceEntry<Object, Object>
{
  INSTANCE;
  
  private MapMakerInternalMap$NullEntry() {}
  
  public MapMakerInternalMap.ValueReference<Object, Object> getValueReference()
  {
    return null;
  }
  
  public void setValueReference(MapMakerInternalMap.ValueReference<Object, Object> valueReference) {}
  
  public MapMakerInternalMap.ReferenceEntry<Object, Object> getNext()
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
  
  public long getExpirationTime()
  {
    return 0L;
  }
  
  public void setExpirationTime(long time) {}
  
  public MapMakerInternalMap.ReferenceEntry<Object, Object> getNextExpirable()
  {
    return this;
  }
  
  public void setNextExpirable(MapMakerInternalMap.ReferenceEntry<Object, Object> next) {}
  
  public MapMakerInternalMap.ReferenceEntry<Object, Object> getPreviousExpirable()
  {
    return this;
  }
  
  public void setPreviousExpirable(MapMakerInternalMap.ReferenceEntry<Object, Object> previous) {}
  
  public MapMakerInternalMap.ReferenceEntry<Object, Object> getNextEvictable()
  {
    return this;
  }
  
  public void setNextEvictable(MapMakerInternalMap.ReferenceEntry<Object, Object> next) {}
  
  public MapMakerInternalMap.ReferenceEntry<Object, Object> getPreviousEvictable()
  {
    return this;
  }
  
  public void setPreviousEvictable(MapMakerInternalMap.ReferenceEntry<Object, Object> previous) {}
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.NullEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */