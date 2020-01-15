package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public final class ImmutableSetMultimap$Builder<K, V>
  extends ImmutableMultimap.Builder<K, V>
{
  public ImmutableSetMultimap$Builder()
  {
    builderMultimap = new ImmutableSetMultimap.BuilderMultimap();
  }
  
  public Builder<K, V> put(K key, V value)
  {
    builderMultimap.put(Preconditions.checkNotNull(key), Preconditions.checkNotNull(value));
    return this;
  }
  
  public Builder<K, V> put(Map.Entry<? extends K, ? extends V> entry)
  {
    builderMultimap.put(Preconditions.checkNotNull(entry.getKey()), Preconditions.checkNotNull(entry.getValue()));
    
    return this;
  }
  
  public Builder<K, V> putAll(K key, Iterable<? extends V> values)
  {
    Collection<V> collection = builderMultimap.get(Preconditions.checkNotNull(key));
    for (V value : values) {
      collection.add(Preconditions.checkNotNull(value));
    }
    return this;
  }
  
  public Builder<K, V> putAll(K key, V... values)
  {
    return putAll(key, Arrays.asList(values));
  }
  
  public Builder<K, V> putAll(Multimap<? extends K, ? extends V> multimap)
  {
    for (Map.Entry<? extends K, ? extends Collection<? extends V>> entry : multimap.asMap().entrySet()) {
      putAll(entry.getKey(), (Iterable)entry.getValue());
    }
    return this;
  }
  
  public Builder<K, V> orderKeysBy(Comparator<? super K> keyComparator)
  {
    this.keyComparator = ((Comparator)Preconditions.checkNotNull(keyComparator));
    return this;
  }
  
  public Builder<K, V> orderValuesBy(Comparator<? super V> valueComparator)
  {
    super.orderValuesBy(valueComparator);
    return this;
  }
  
  public ImmutableSetMultimap<K, V> build()
  {
    if (keyComparator != null)
    {
      Multimap<K, V> sortedCopy = new ImmutableSetMultimap.BuilderMultimap();
      List<Map.Entry<K, Collection<V>>> entries = Lists.newArrayList(builderMultimap.asMap().entrySet());
      
      Collections.sort(entries, Ordering.from(keyComparator).onKeys());
      for (Map.Entry<K, Collection<V>> entry : entries) {
        sortedCopy.putAll(entry.getKey(), (Iterable)entry.getValue());
      }
      builderMultimap = sortedCopy;
    }
    return ImmutableSetMultimap.access$000(builderMultimap, valueComparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableSetMultimap.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */