package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collections;
import java.util.Comparator;
import java.util.SortedSet;

class Multimaps$UnmodifiableSortedSetMultimap<K, V>
  extends Multimaps.UnmodifiableSetMultimap<K, V>
  implements SortedSetMultimap<K, V>
{
  private static final long serialVersionUID = 0L;
  
  Multimaps$UnmodifiableSortedSetMultimap(SortedSetMultimap<K, V> delegate)
  {
    super(delegate);
  }
  
  public SortedSetMultimap<K, V> delegate()
  {
    return (SortedSetMultimap)super.delegate();
  }
  
  public SortedSet<V> get(K key)
  {
    return Collections.unmodifiableSortedSet(delegate().get(key));
  }
  
  public SortedSet<V> removeAll(Object key)
  {
    throw new UnsupportedOperationException();
  }
  
  public SortedSet<V> replaceValues(K key, Iterable<? extends V> values)
  {
    throw new UnsupportedOperationException();
  }
  
  public Comparator<? super V> valueComparator()
  {
    return delegate().valueComparator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.UnmodifiableSortedSetMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */