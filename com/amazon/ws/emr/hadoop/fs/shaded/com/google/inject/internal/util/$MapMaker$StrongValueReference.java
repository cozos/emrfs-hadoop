package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$StrongValueReference<K, V>
  implements .MapMaker.ValueReference<K, V>
{
  final V referent;
  
  $MapMaker$StrongValueReference(V referent)
  {
    this.referent = referent;
  }
  
  public V get()
  {
    return (V)referent;
  }
  
  public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
  {
    return this;
  }
  
  public V waitForValue()
  {
    return (V)get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.StrongValueReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */