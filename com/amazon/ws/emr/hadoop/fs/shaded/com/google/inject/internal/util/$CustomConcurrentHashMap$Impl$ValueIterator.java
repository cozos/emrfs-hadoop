package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;

final class $CustomConcurrentHashMap$Impl$ValueIterator
  extends .CustomConcurrentHashMap.Impl<K, V, E>.HashIterator
  implements Iterator<V>
{
  $CustomConcurrentHashMap$Impl$ValueIterator(.CustomConcurrentHashMap.Impl paramImpl)
  {
    super(paramImpl);
  }
  
  public V next()
  {
    return (V)super.nextEntry().getValue();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.ValueIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */