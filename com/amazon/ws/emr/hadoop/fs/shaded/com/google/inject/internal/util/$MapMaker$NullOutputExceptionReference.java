package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $MapMaker$NullOutputExceptionReference<K, V>
  implements .MapMaker.ValueReference<K, V>
{
  final String message;
  
  $MapMaker$NullOutputExceptionReference(String message)
  {
    this.message = message;
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
    throw new .NullOutputException(message);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..MapMaker.NullOutputExceptionReference
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */