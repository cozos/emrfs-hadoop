package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Predicates;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
class Maps$FilteredEntryNavigableMap<K, V>
  extends AbstractNavigableMap<K, V>
{
  private final NavigableMap<K, V> unfiltered;
  private final Predicate<? super Map.Entry<K, V>> entryPredicate;
  private final Map<K, V> filteredDelegate;
  
  Maps$FilteredEntryNavigableMap(NavigableMap<K, V> unfiltered, Predicate<? super Map.Entry<K, V>> entryPredicate)
  {
    this.unfiltered = ((NavigableMap)Preconditions.checkNotNull(unfiltered));
    this.entryPredicate = entryPredicate;
    filteredDelegate = new Maps.FilteredEntryMap(unfiltered, entryPredicate);
  }
  
  public Comparator<? super K> comparator()
  {
    return unfiltered.comparator();
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    new Maps.NavigableKeySet(this)
    {
      public boolean removeAll(Collection<?> c)
      {
        return Iterators.removeIf(unfiltered.entrySet().iterator(), Predicates.and(entryPredicate, Maps.keyPredicateOnEntries(Predicates.in(c))));
      }
      
      public boolean retainAll(Collection<?> c)
      {
        return Iterators.removeIf(unfiltered.entrySet().iterator(), Predicates.and(entryPredicate, Maps.keyPredicateOnEntries(Predicates.not(Predicates.in(c)))));
      }
    };
  }
  
  public Collection<V> values()
  {
    return new Maps.FilteredMapValues(this, unfiltered, entryPredicate);
  }
  
  Iterator<Map.Entry<K, V>> entryIterator()
  {
    return Iterators.filter(unfiltered.entrySet().iterator(), entryPredicate);
  }
  
  Iterator<Map.Entry<K, V>> descendingEntryIterator()
  {
    return Iterators.filter(unfiltered.descendingMap().entrySet().iterator(), entryPredicate);
  }
  
  public int size()
  {
    return filteredDelegate.size();
  }
  
  public boolean isEmpty()
  {
    return !Iterables.any(unfiltered.entrySet(), entryPredicate);
  }
  
  @Nullable
  public V get(@Nullable Object key)
  {
    return (V)filteredDelegate.get(key);
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return filteredDelegate.containsKey(key);
  }
  
  public V put(K key, V value)
  {
    return (V)filteredDelegate.put(key, value);
  }
  
  public V remove(@Nullable Object key)
  {
    return (V)filteredDelegate.remove(key);
  }
  
  public void putAll(Map<? extends K, ? extends V> m)
  {
    filteredDelegate.putAll(m);
  }
  
  public void clear()
  {
    filteredDelegate.clear();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    return filteredDelegate.entrySet();
  }
  
  public Map.Entry<K, V> pollFirstEntry()
  {
    return (Map.Entry)Iterables.removeFirstMatching(unfiltered.entrySet(), entryPredicate);
  }
  
  public Map.Entry<K, V> pollLastEntry()
  {
    return (Map.Entry)Iterables.removeFirstMatching(unfiltered.descendingMap().entrySet(), entryPredicate);
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    return Maps.filterEntries(unfiltered.descendingMap(), entryPredicate);
  }
  
  public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
  {
    return Maps.filterEntries(unfiltered.subMap(fromKey, fromInclusive, toKey, toInclusive), entryPredicate);
  }
  
  public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
  {
    return Maps.filterEntries(unfiltered.headMap(toKey, inclusive), entryPredicate);
  }
  
  public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
  {
    return Maps.filterEntries(unfiltered.tailMap(fromKey, inclusive), entryPredicate);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntryNavigableMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */