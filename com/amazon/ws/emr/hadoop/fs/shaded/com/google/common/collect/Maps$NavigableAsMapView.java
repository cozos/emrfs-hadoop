package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
final class Maps$NavigableAsMapView<K, V>
  extends AbstractNavigableMap<K, V>
{
  private final NavigableSet<K> set;
  private final Function<? super K, V> function;
  
  Maps$NavigableAsMapView(NavigableSet<K> ks, Function<? super K, V> vFunction)
  {
    set = ((NavigableSet)Preconditions.checkNotNull(ks));
    function = ((Function)Preconditions.checkNotNull(vFunction));
  }
  
  public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
  {
    return Maps.asMap(set.subSet(fromKey, fromInclusive, toKey, toInclusive), function);
  }
  
  public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
  {
    return Maps.asMap(set.headSet(toKey, inclusive), function);
  }
  
  public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
  {
    return Maps.asMap(set.tailSet(fromKey, inclusive), function);
  }
  
  public Comparator<? super K> comparator()
  {
    return set.comparator();
  }
  
  @Nullable
  public V get(@Nullable Object key)
  {
    if (Collections2.safeContains(set, key))
    {
      K k = (K)key;
      return (V)function.apply(k);
    }
    return null;
  }
  
  public void clear()
  {
    set.clear();
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return Maps.asMapEntryIterator(set, function);
  }
  
  Iterator<Map.Entry<K, V>> descendingEntryIterator()
  {
    return descendingMap().entrySet().iterator();
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    return Maps.access$400(set);
  }
  
  public int size()
  {
    return set.size();
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    return Maps.asMap(set.descendingSet(), function);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.NavigableAsMapView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */