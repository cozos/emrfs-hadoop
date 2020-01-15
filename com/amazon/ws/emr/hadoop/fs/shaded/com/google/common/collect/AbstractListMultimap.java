package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractListMultimap<K, V>
  extends AbstractMapBasedMultimap<K, V>
  implements ListMultimap<K, V>
{
  private static final long serialVersionUID = 6588350623831699109L;
  
  protected AbstractListMultimap(Map<K, Collection<V>> map)
  {
    super(map);
  }
  
  abstract List<V> createCollection();
  
  List<V> createUnmodifiableEmptyCollection()
  {
    return ImmutableList.of();
  }
  
  public List<V> get(@Nullable K key)
  {
    return (List)super.get(key);
  }
  
  public List<V> removeAll(@Nullable Object key)
  {
    return (List)super.removeAll(key);
  }
  
  public List<V> replaceValues(@Nullable K key, Iterable<? extends V> values)
  {
    return (List)super.replaceValues(key, values);
  }
  
  public boolean put(@Nullable K key, @Nullable V value)
  {
    return super.put(key, value);
  }
  
  public Map<K, Collection<V>> asMap()
  {
    return super.asMap();
  }
  
  public boolean equals(@Nullable Object object)
  {
    return super.equals(object);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractListMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */