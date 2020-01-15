package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.io.Serializable;
import java.util.Collections;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

@GwtIncompatible("NavigableMap")
class Maps$UnmodifiableNavigableMap<K, V>
  extends ForwardingSortedMap<K, V>
  implements NavigableMap<K, V>, Serializable
{
  private final NavigableMap<K, V> delegate;
  private transient UnmodifiableNavigableMap<K, V> descendingMap;
  
  Maps$UnmodifiableNavigableMap(NavigableMap<K, V> delegate)
  {
    this.delegate = delegate;
  }
  
  Maps$UnmodifiableNavigableMap(NavigableMap<K, V> delegate, UnmodifiableNavigableMap<K, V> descendingMap)
  {
    this.delegate = delegate;
    this.descendingMap = descendingMap;
  }
  
  protected SortedMap<K, V> delegate()
  {
    return Collections.unmodifiableSortedMap(delegate);
  }
  
  public Map.Entry<K, V> lowerEntry(K key)
  {
    return Maps.access$800(delegate.lowerEntry(key));
  }
  
  public K lowerKey(K key)
  {
    return (K)delegate.lowerKey(key);
  }
  
  public Map.Entry<K, V> floorEntry(K key)
  {
    return Maps.access$800(delegate.floorEntry(key));
  }
  
  public K floorKey(K key)
  {
    return (K)delegate.floorKey(key);
  }
  
  public Map.Entry<K, V> ceilingEntry(K key)
  {
    return Maps.access$800(delegate.ceilingEntry(key));
  }
  
  public K ceilingKey(K key)
  {
    return (K)delegate.ceilingKey(key);
  }
  
  public Map.Entry<K, V> higherEntry(K key)
  {
    return Maps.access$800(delegate.higherEntry(key));
  }
  
  public K higherKey(K key)
  {
    return (K)delegate.higherKey(key);
  }
  
  public Map.Entry<K, V> firstEntry()
  {
    return Maps.access$800(delegate.firstEntry());
  }
  
  public Map.Entry<K, V> lastEntry()
  {
    return Maps.access$800(delegate.lastEntry());
  }
  
  public final Map.Entry<K, V> pollFirstEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public final Map.Entry<K, V> pollLastEntry()
  {
    throw new UnsupportedOperationException();
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    UnmodifiableNavigableMap<K, V> result = descendingMap;
    return result == null ? (descendingMap = new UnmodifiableNavigableMap(delegate.descendingMap(), this)) : result;
  }
  
  public Set<K> keySet()
  {
    return navigableKeySet();
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    return Sets.unmodifiableNavigableSet(delegate.navigableKeySet());
  }
  
  public NavigableSet<K> descendingKeySet()
  {
    return Sets.unmodifiableNavigableSet(delegate.descendingKeySet());
  }
  
  public SortedMap<K, V> subMap(K fromKey, K toKey)
  {
    return subMap(fromKey, true, toKey, false);
  }
  
  public SortedMap<K, V> headMap(K toKey)
  {
    return headMap(toKey, false);
  }
  
  public SortedMap<K, V> tailMap(K fromKey)
  {
    return tailMap(fromKey, true);
  }
  
  public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
  {
    return Maps.unmodifiableNavigableMap(delegate.subMap(fromKey, fromInclusive, toKey, toInclusive));
  }
  
  public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
  {
    return Maps.unmodifiableNavigableMap(delegate.headMap(toKey, inclusive));
  }
  
  public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
  {
    return Maps.unmodifiableNavigableMap(delegate.tailMap(fromKey, inclusive));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.UnmodifiableNavigableMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */