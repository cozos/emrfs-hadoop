package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedMap;

@GwtIncompatible("NavigableMap")
abstract class Maps$DescendingMap<K, V>
  extends ForwardingMap<K, V>
  implements NavigableMap<K, V>
{
  private transient Comparator<? super K> comparator;
  private transient Set<Map.Entry<K, V>> entrySet;
  private transient NavigableSet<K> navigableKeySet;
  
  abstract NavigableMap<K, V> forward();
  
  protected final Map<K, V> delegate()
  {
    return forward();
  }
  
  public Comparator<? super K> comparator()
  {
    Comparator<? super K> result = comparator;
    if (result == null)
    {
      Comparator<? super K> forwardCmp = forward().comparator();
      if (forwardCmp == null) {
        forwardCmp = Ordering.natural();
      }
      result = comparator = reverse(forwardCmp);
    }
    return result;
  }
  
  private static <T> Ordering<T> reverse(Comparator<T> forward)
  {
    return Ordering.from(forward).reverse();
  }
  
  public K firstKey()
  {
    return (K)forward().lastKey();
  }
  
  public K lastKey()
  {
    return (K)forward().firstKey();
  }
  
  public Map.Entry<K, V> lowerEntry(K key)
  {
    return forward().higherEntry(key);
  }
  
  public K lowerKey(K key)
  {
    return (K)forward().higherKey(key);
  }
  
  public Map.Entry<K, V> floorEntry(K key)
  {
    return forward().ceilingEntry(key);
  }
  
  public K floorKey(K key)
  {
    return (K)forward().ceilingKey(key);
  }
  
  public Map.Entry<K, V> ceilingEntry(K key)
  {
    return forward().floorEntry(key);
  }
  
  public K ceilingKey(K key)
  {
    return (K)forward().floorKey(key);
  }
  
  public Map.Entry<K, V> higherEntry(K key)
  {
    return forward().lowerEntry(key);
  }
  
  public K higherKey(K key)
  {
    return (K)forward().lowerKey(key);
  }
  
  public Map.Entry<K, V> firstEntry()
  {
    return forward().lastEntry();
  }
  
  public Map.Entry<K, V> lastEntry()
  {
    return forward().firstEntry();
  }
  
  public Map.Entry<K, V> pollFirstEntry()
  {
    return forward().pollLastEntry();
  }
  
  public Map.Entry<K, V> pollLastEntry()
  {
    return forward().pollFirstEntry();
  }
  
  public NavigableMap<K, V> descendingMap()
  {
    return forward();
  }
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set<Map.Entry<K, V>> result = entrySet;
    return result == null ? (entrySet = createEntrySet()) : result;
  }
  
  abstract Iterator<Map.Entry<K, V>> entryIterator();
  
  Set<Map.Entry<K, V>> createEntrySet()
  {
    new Maps.EntrySet()
    {
      Map<K, V> map()
      {
        return Maps.DescendingMap.this;
      }
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        return entryIterator();
      }
    };
  }
  
  public Set<K> keySet()
  {
    return navigableKeySet();
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    NavigableSet<K> result = navigableKeySet;
    return result == null ? (navigableKeySet = new Maps.NavigableKeySet(this)) : result;
  }
  
  public NavigableSet<K> descendingKeySet()
  {
    return forward().navigableKeySet();
  }
  
  public NavigableMap<K, V> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
  {
    return forward().subMap(toKey, toInclusive, fromKey, fromInclusive).descendingMap();
  }
  
  public NavigableMap<K, V> headMap(K toKey, boolean inclusive)
  {
    return forward().tailMap(toKey, inclusive).descendingMap();
  }
  
  public NavigableMap<K, V> tailMap(K fromKey, boolean inclusive)
  {
    return forward().headMap(fromKey, inclusive).descendingMap();
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
  
  public Collection<V> values()
  {
    return new Maps.Values(this);
  }
  
  public String toString()
  {
    return standardToString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.DescendingMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */