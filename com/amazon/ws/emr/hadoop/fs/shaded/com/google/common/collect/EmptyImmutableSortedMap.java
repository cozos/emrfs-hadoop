package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map.Entry;
import javax.annotation.Nullable;

@GwtCompatible(emulated=true)
final class EmptyImmutableSortedMap<K, V>
  extends ImmutableSortedMap<K, V>
{
  private final transient ImmutableSortedSet<K> keySet;
  
  EmptyImmutableSortedMap(Comparator<? super K> comparator)
  {
    keySet = ImmutableSortedSet.emptySet(comparator);
  }
  
  EmptyImmutableSortedMap(Comparator<? super K> comparator, ImmutableSortedMap<K, V> descendingMap)
  {
    super(descendingMap);
    keySet = ImmutableSortedSet.emptySet(comparator);
  }
  
  public V get(@Nullable Object key)
  {
    return null;
  }
  
  public ImmutableSortedSet<K> keySet()
  {
    return keySet;
  }
  
  public int size()
  {
    return 0;
  }
  
  public boolean isEmpty()
  {
    return true;
  }
  
  public ImmutableCollection<V> values()
  {
    return ImmutableList.of();
  }
  
  public String toString()
  {
    return "{}";
  }
  
  boolean isPartialView()
  {
    return false;
  }
  
  public ImmutableSet<Map.Entry<K, V>> entrySet()
  {
    return ImmutableSet.of();
  }
  
  ImmutableSet<Map.Entry<K, V>> createEntrySet()
  {
    throw new AssertionError("should never be called");
  }
  
  public ImmutableSetMultimap<K, V> asMultimap()
  {
    return ImmutableSetMultimap.of();
  }
  
  public ImmutableSortedMap<K, V> headMap(K toKey, boolean inclusive)
  {
    Preconditions.checkNotNull(toKey);
    return this;
  }
  
  public ImmutableSortedMap<K, V> tailMap(K fromKey, boolean inclusive)
  {
    Preconditions.checkNotNull(fromKey);
    return this;
  }
  
  ImmutableSortedMap<K, V> createDescendingMap()
  {
    return new EmptyImmutableSortedMap(Ordering.from(comparator()).reverse(), this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.EmptyImmutableSortedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */