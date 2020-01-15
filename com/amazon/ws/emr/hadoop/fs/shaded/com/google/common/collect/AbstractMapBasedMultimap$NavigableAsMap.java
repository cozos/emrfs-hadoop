package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Set;

@GwtIncompatible("NavigableAsMap")
class AbstractMapBasedMultimap$NavigableAsMap
  extends AbstractMapBasedMultimap<K, V>.SortedAsMap
  implements NavigableMap<K, Collection<V>>
{
  AbstractMapBasedMultimap$NavigableAsMap(NavigableMap<K, Collection<V>> arg1)
  {
    super(???, submap);
  }
  
  NavigableMap<K, Collection<V>> sortedMap()
  {
    return (NavigableMap)super.sortedMap();
  }
  
  public Map.Entry<K, Collection<V>> lowerEntry(K key)
  {
    Map.Entry<K, Collection<V>> entry = sortedMap().lowerEntry(key);
    return entry == null ? null : wrapEntry(entry);
  }
  
  public K lowerKey(K key)
  {
    return (K)sortedMap().lowerKey(key);
  }
  
  public Map.Entry<K, Collection<V>> floorEntry(K key)
  {
    Map.Entry<K, Collection<V>> entry = sortedMap().floorEntry(key);
    return entry == null ? null : wrapEntry(entry);
  }
  
  public K floorKey(K key)
  {
    return (K)sortedMap().floorKey(key);
  }
  
  public Map.Entry<K, Collection<V>> ceilingEntry(K key)
  {
    Map.Entry<K, Collection<V>> entry = sortedMap().ceilingEntry(key);
    return entry == null ? null : wrapEntry(entry);
  }
  
  public K ceilingKey(K key)
  {
    return (K)sortedMap().ceilingKey(key);
  }
  
  public Map.Entry<K, Collection<V>> higherEntry(K key)
  {
    Map.Entry<K, Collection<V>> entry = sortedMap().higherEntry(key);
    return entry == null ? null : wrapEntry(entry);
  }
  
  public K higherKey(K key)
  {
    return (K)sortedMap().higherKey(key);
  }
  
  public Map.Entry<K, Collection<V>> firstEntry()
  {
    Map.Entry<K, Collection<V>> entry = sortedMap().firstEntry();
    return entry == null ? null : wrapEntry(entry);
  }
  
  public Map.Entry<K, Collection<V>> lastEntry()
  {
    Map.Entry<K, Collection<V>> entry = sortedMap().lastEntry();
    return entry == null ? null : wrapEntry(entry);
  }
  
  public Map.Entry<K, Collection<V>> pollFirstEntry()
  {
    return pollAsMapEntry(entrySet().iterator());
  }
  
  public Map.Entry<K, Collection<V>> pollLastEntry()
  {
    return pollAsMapEntry(descendingMap().entrySet().iterator());
  }
  
  Map.Entry<K, Collection<V>> pollAsMapEntry(Iterator<Map.Entry<K, Collection<V>>> entryIterator)
  {
    if (!entryIterator.hasNext()) {
      return null;
    }
    Map.Entry<K, Collection<V>> entry = (Map.Entry)entryIterator.next();
    Collection<V> output = this$0.createCollection();
    output.addAll((Collection)entry.getValue());
    entryIterator.remove();
    return Maps.immutableEntry(entry.getKey(), this$0.unmodifiableCollectionSubclass(output));
  }
  
  public NavigableMap<K, Collection<V>> descendingMap()
  {
    return new NavigableAsMap(this$0, sortedMap().descendingMap());
  }
  
  public NavigableSet<K> keySet()
  {
    return (NavigableSet)super.keySet();
  }
  
  NavigableSet<K> createKeySet()
  {
    return new AbstractMapBasedMultimap.NavigableKeySet(this$0, sortedMap());
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    return keySet();
  }
  
  public NavigableSet<K> descendingKeySet()
  {
    return descendingMap().navigableKeySet();
  }
  
  public NavigableMap<K, Collection<V>> subMap(K fromKey, K toKey)
  {
    return subMap(fromKey, true, toKey, false);
  }
  
  public NavigableMap<K, Collection<V>> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
  {
    return new NavigableAsMap(this$0, sortedMap().subMap(fromKey, fromInclusive, toKey, toInclusive));
  }
  
  public NavigableMap<K, Collection<V>> headMap(K toKey)
  {
    return headMap(toKey, false);
  }
  
  public NavigableMap<K, Collection<V>> headMap(K toKey, boolean inclusive)
  {
    return new NavigableAsMap(this$0, sortedMap().headMap(toKey, inclusive));
  }
  
  public NavigableMap<K, Collection<V>> tailMap(K fromKey)
  {
    return tailMap(fromKey, true);
  }
  
  public NavigableMap<K, Collection<V>> tailMap(K fromKey, boolean inclusive)
  {
    return new NavigableAsMap(this$0, sortedMap().tailMap(fromKey, inclusive));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.NavigableAsMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */