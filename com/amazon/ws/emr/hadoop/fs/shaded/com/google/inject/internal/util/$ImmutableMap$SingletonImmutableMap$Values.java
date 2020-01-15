package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

class $ImmutableMap$SingletonImmutableMap$Values<V>
  extends .ImmutableCollection<V>
{
  final V singleValue;
  
  $ImmutableMap$SingletonImmutableMap$Values(V singleValue)
  {
    this.singleValue = singleValue;
  }
  
  public boolean contains(Object object)
  {
    return singleValue.equals(object);
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public int size()
  {
    return 1;
  }
  
  public .UnmodifiableIterator<V> iterator()
  {
    return .Iterators.singletonIterator(singleValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..ImmutableMap.SingletonImmutableMap.Values
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */