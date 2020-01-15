package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.Map.Entry;

public final class ImmutableListMultimap$Builder<K, V>
  extends ImmutableMultimap.Builder<K, V>
{
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
  
  public Builder<K, V> putAll(K key, Iterable<? extends V> values)
  {
    super.putAll(key, values);
    return this;
  }
  
  public Builder<K, V> putAll(K key, V... values)
  {
    super.putAll(key, values);
    return this;
  }
  
  public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap)
  {
    super.putAll(multimap);
    return this;
  }
  
  public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator)
  {
    super.orderKeysBy(keyComparator);
    return this;
  }
  
  public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator)
  {
    super.orderValuesBy(valueComparator);
    return this;
  }
  
  public ImmutableListMultimap<K, V> build()
  {
    return (ImmutableListMultimap)super.build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableListMultimap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */