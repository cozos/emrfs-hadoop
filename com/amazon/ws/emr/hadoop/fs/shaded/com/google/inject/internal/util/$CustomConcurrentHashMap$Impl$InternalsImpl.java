package com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util;

import java.io.Serializable;

class $CustomConcurrentHashMap$Impl$InternalsImpl
  implements .CustomConcurrentHashMap.Internals<K, V, E>, Serializable
{
  static final long serialVersionUID = 0L;
  
  $CustomConcurrentHashMap$Impl$InternalsImpl(.CustomConcurrentHashMap.Impl paramImpl) {}
  
  public E getEntry(K key)
  {
    if (key == null) {
      throw new NullPointerException("key");
    }
    int hash = this$0.hash(key);
    return (E)this$0.segmentFor(hash).getEntry(key, hash);
  }
  
  public boolean removeEntry(E entry, V value)
  {
    if (entry == null) {
      throw new NullPointerException("entry");
    }
    int hash = this$0.strategy.getHash(entry);
    return this$0.segmentFor(hash).removeEntry(entry, hash, value);
  }
  
  public boolean removeEntry(E entry)
  {
    if (entry == null) {
      throw new NullPointerException("entry");
    }
    int hash = this$0.strategy.getHash(entry);
    return this$0.segmentFor(hash).removeEntry(entry, hash);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.inject.internal.util..CustomConcurrentHashMap.Impl.InternalsImpl
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */