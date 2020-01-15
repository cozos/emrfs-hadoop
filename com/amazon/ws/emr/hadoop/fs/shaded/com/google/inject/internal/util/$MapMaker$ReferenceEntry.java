package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

abstract interface $MapMaker$ReferenceEntry<K, V>
{
  public abstract .MapMaker.ValueReference<K, V> getValueReference();
  
  public abstract void setValueReference(.MapMaker.ValueReference<K, V> paramValueReference);
  
  public abstract void valueReclaimed();
  
  public abstract ReferenceEntry<K, V> getNext();
  
  public abstract int getHash();
  
  public abstract K getKey();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.ReferenceEntry
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */