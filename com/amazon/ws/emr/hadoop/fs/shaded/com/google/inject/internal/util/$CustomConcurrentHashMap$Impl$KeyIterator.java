package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;

final class $CustomConcurrentHashMap$Impl$KeyIterator
  extends .CustomConcurrentHashMap.Impl<K, V, E>.HashIterator
  implements Iterator<K>
{
  $CustomConcurrentHashMap$Impl$KeyIterator(.CustomConcurrentHashMap.Impl paramImpl)
  {
    super(paramImpl);
  }
  
  public K next()
  {
    return (K)super.nextEntry().getKey();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.KeyIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */