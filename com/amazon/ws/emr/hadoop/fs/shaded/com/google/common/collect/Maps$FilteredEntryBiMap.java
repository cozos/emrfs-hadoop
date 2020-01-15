package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

final class Maps$FilteredEntryBiMap<K, V>
  extends Maps.FilteredEntryMap<K, V>
  implements BiMap<K, V>
{
  private final BiMap<V, K> inverse;
  
  private static <K, V> Predicate<Map.Entry<V, K>> inversePredicate(Predicate<? super Map.Entry<K, V>> forwardPredicate)
  {
    new Predicate()
    {
      public boolean apply(Map.Entry<V, K> input)
      {
        return val$forwardPredicate.apply(Maps.immutableEntry(input.getValue(), input.getKey()));
      }
    };
  }
  
  Maps$FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate)
  {
    super(delegate, predicate);
    inverse = new FilteredEntryBiMap(delegate.inverse(), inversePredicate(predicate), this);
  }
  
  private Maps$FilteredEntryBiMap(BiMap<K, V> delegate, Predicate<? super Map.Entry<K, V>> predicate, BiMap<V, K> inverse)
  {
    super(delegate, predicate);
    this.inverse = inverse;
  }
  
  BiMap<K, V> unfiltered()
  {
    return (BiMap)unfiltered;
  }
  
  public V forcePut(@Nullable K key, @Nullable V value)
  {
    Preconditions.checkArgument(apply(key, value));
    return (V)unfiltered().forcePut(key, value);
  }
  
  public BiMap<V, K> inverse()
  {
    return inverse;
  }
  
  public Set<V> values()
  {
    return inverse.keySet();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntryBiMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */