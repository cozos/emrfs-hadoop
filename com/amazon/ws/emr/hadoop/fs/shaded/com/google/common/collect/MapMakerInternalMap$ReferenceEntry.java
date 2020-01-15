package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

abstract interface MapMakerInternalMap$ReferenceEntry<K, V>
{
  public abstract MapMakerInternalMap.ValueReference<K, V> getValueReference();
  
  public abstract void setValueReference(MapMakerInternalMap.ValueReference<K, V> paramValueReference);
  
  public abstract ReferenceEntry<K, V> getNext();
  
  public abstract int getHash();
  
  public abstract K getKey();
  
  public abstract long getExpirationTime();
  
  public abstract void setExpirationTime(long paramLong);
  
  public abstract ReferenceEntry<K, V> getNextExpirable();
  
  public abstract void setNextExpirable(ReferenceEntry<K, V> paramReferenceEntry);
  
  public abstract ReferenceEntry<K, V> getPreviousExpirable();
  
  public abstract void setPreviousExpirable(ReferenceEntry<K, V> paramReferenceEntry);
  
  public abstract ReferenceEntry<K, V> getNextEvictable();
  
  public abstract void setNextEvictable(ReferenceEntry<K, V> paramReferenceEntry);
  
  public abstract ReferenceEntry<K, V> getPreviousEvictable();
  
  public abstract void setPreviousEvictable(ReferenceEntry<K, V> paramReferenceEntry);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapMakerInternalMap.ReferenceEntry
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */