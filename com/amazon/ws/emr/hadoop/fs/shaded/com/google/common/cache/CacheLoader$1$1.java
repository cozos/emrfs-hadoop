package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.util.concurrent.ListenableFuture;
import java.util.concurrent.Callable;

class CacheLoader$1$1
  implements Callable<V>
{
  CacheLoader$1$1(CacheLoader.1 param1, Object paramObject1, Object paramObject2) {}
  
  public V call()
    throws Exception
  {
    return (V)this$0.val$loader.reload(val$key, val$oldValue).get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */