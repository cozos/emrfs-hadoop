package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$ComputationExceptionReference<K, V>
  implements .MapMaker.ValueReference<K, V>
{
  final Throwable t;
  
  $MapMaker$ComputationExceptionReference(Throwable t)
  {
    this.t = t;
  }
  
  public V get()
  {
    return null;
  }
  
  public .MapMaker.ValueReference<K, V> copyFor(.MapMaker.ReferenceEntry<K, V> entry)
  {
    return this;
  }
  
  public V waitForValue()
  {
    throw new .AsynchronousComputationException(t);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.ComputationExceptionReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */