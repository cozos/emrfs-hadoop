package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import java.util.List;
import javax.annotation.Nullable;

@GwtCompatible
final class FilteredKeyListMultimap<K, V>
  extends FilteredKeyMultimap<K, V>
  implements ListMultimap<K, V>
{
  FilteredKeyListMultimap(ListMultimap<K, V> unfiltered, Predicate<? super K> keyPredicate)
  {
    super(unfiltered, keyPredicate);
  }
  
  public ListMultimap<K, V> unfiltered()
  {
    return (ListMultimap)super.unfiltered();
  }
  
  public List<V> get(K key)
  {
    return (List)super.get(key);
  }
  
  public List<V> removeAll(@Nullable Object key)
  {
    return (List)super.removeAll(key);
  }
  
  public List<V> replaceValues(K key, Iterable<? extends V> values)
  {
    return (List)super.replaceValues(key, values);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.FilteredKeyListMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */