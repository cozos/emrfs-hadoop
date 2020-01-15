package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Comparator;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public abstract class ForwardingSortedSetMultimap<K, V>
  extends ForwardingSetMultimap<K, V>
  implements SortedSetMultimap<K, V>
{
  protected abstract SortedSetMultimap<K, V> delegate();
  
  public SortedSet<V> get(@Nullable K key)
  {
    return delegate().get(key);
  }
  
  public SortedSet<V> removeAll(@Nullable Object key)
  {
    return delegate().removeAll(key);
  }
  
  public SortedSet<V> replaceValues(K key, Iterable<? extends V> values)
  {
    return delegate().replaceValues(key, values);
  }
  
  public Comparator<? super V> valueComparator()
  {
    return delegate().valueComparator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ForwardingSortedSetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */