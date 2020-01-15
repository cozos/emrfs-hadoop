package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@Beta
public abstract interface RangeMap<K extends Comparable, V>
{
  @Nullable
  public abstract V get(K paramK);
  
  @Nullable
  public abstract Map.Entry<Range<K>, V> getEntry(K paramK);
  
  public abstract Range<K> span();
  
  public abstract void put(Range<K> paramRange, V paramV);
  
  public abstract void putAll(RangeMap<K, V> paramRangeMap);
  
  public abstract void clear();
  
  public abstract void remove(Range<K> paramRange);
  
  public abstract Map<Range<K>, V> asMapOfRanges();
  
  public abstract RangeMap<K, V> subRangeMap(Range<K> paramRange);
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
  
  public abstract String toString();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RangeMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */