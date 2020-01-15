package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
public abstract interface SetMultimap<K, V>
  extends Multimap<K, V>
{
  public abstract Set<V> get(@Nullable K paramK);
  
  public abstract Set<V> removeAll(@Nullable Object paramObject);
  
  public abstract Set<V> replaceValues(K paramK, Iterable<? extends V> paramIterable);
  
  public abstract Set<Map.Entry<K, V>> entries();
  
  public abstract Map<K, Collection<V>> asMap();
  
  public abstract boolean equals(@Nullable Object paramObject);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */