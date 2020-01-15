package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

public class ImmutableSortedMap$Builder<K, V>
  extends ImmutableMap.Builder<K, V>
{
  private final Comparator<? super K> comparator;
  
  public ImmutableSortedMap$Builder(Comparator<? super K> comparator)
  {
    this.comparator = ((Comparator)Preconditions.checkNotNull(comparator));
  }
  
  public Builder<K, V> put(K key, V value)
  {
    super.put(key, value);
    return this;
  }
  
  public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry)
  {
    super.put(entry);
    return this;
  }
  
  public Builder<K, V> putAll(Map<? extends K, ? extends V> map)
  {
    super.putAll(map);
    return this;
  }
  
  public ImmutableSortedMap<K, V> build()
  {
    return ImmutableSortedMap.fromEntries(comparator, false, size, entries);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSortedMap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */