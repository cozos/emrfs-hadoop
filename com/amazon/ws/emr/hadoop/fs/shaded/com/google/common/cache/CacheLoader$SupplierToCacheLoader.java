package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;

final class CacheLoader$SupplierToCacheLoader<V>
  extends CacheLoader<Object, V>
  implements Serializable
{
  private final Supplier<V> computingSupplier;
  private static final long serialVersionUID = 0L;
  
  public CacheLoader$SupplierToCacheLoader(Supplier<V> computingSupplier)
  {
    this.computingSupplier = ((Supplier)Preconditions.checkNotNull(computingSupplier));
  }
  
  public V load(Object key)
  {
    Preconditions.checkNotNull(key);
    return (V)computingSupplier.get();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheLoader.SupplierToCacheLoader
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */