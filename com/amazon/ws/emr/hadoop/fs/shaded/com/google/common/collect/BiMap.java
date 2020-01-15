package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface BiMap<K, V>
  extends Map<K, V>
{
  public abstract V put(@Nullable K paramK, @Nullable V paramV);
  
  public abstract V forcePut(@Nullable K paramK, @Nullable V paramV);
  
  public abstract void putAll(Map<? extends K, ? extends V> paramMap);
  
  public abstract Set<V> values();
  
  public abstract BiMap<V, K> inverse();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.BiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */