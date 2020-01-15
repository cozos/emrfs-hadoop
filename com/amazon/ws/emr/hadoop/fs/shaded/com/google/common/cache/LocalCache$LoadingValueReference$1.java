package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

class LocalCache$LoadingValueReference$1
  implements Function<V, V>
{
  LocalCache$LoadingValueReference$1(LocalCache.LoadingValueReference paramLoadingValueReference) {}
  
  public V apply(V newValue)
  {
    this$0.set(newValue);
    return newValue;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.LocalCache.LoadingValueReference.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */