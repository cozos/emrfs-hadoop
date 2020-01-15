package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.util.Iterator;
import java.util.Map.Entry;

final class $CustomConcurrentHashMap$Impl$EntryIterator
  extends .CustomConcurrentHashMap.Impl<K, V, E>.HashIterator
  implements Iterator<Map.Entry<K, V>>
{
  $CustomConcurrentHashMap$Impl$EntryIterator(.CustomConcurrentHashMap.Impl paramImpl)
  {
    super(paramImpl);
  }
  
  public Map.Entry<K, V> next()
  {
    return nextEntry();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.EntryIterator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */