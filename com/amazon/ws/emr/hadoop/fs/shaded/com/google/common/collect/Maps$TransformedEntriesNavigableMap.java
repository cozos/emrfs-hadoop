package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import java.util.Map.Entry;
import java.util.NavigableMap;
import java.util.NavigableSet;
import javax.annotation.Nullable;

@GwtIncompatible("NavigableMap")
class Maps$TransformedEntriesNavigableMap<K, V1, V2>
  extends Maps.TransformedEntriesSortedMap<K, V1, V2>
  implements NavigableMap<K, V2>
{
  Maps$TransformedEntriesNavigableMap(NavigableMap<K, V1> fromMap, Maps.EntryTransformer<? super K, ? super V1, V2> transformer)
  {
    super(fromMap, transformer);
  }
  
  public Map.Entry<K, V2> ceilingEntry(K key)
  {
    return transformEntry(fromMap().ceilingEntry(key));
  }
  
  public K ceilingKey(K key)
  {
    return (K)fromMap().ceilingKey(key);
  }
  
  public NavigableSet<K> descendingKeySet()
  {
    return fromMap().descendingKeySet();
  }
  
  public NavigableMap<K, V2> descendingMap()
  {
    return Maps.transformEntries(fromMap().descendingMap(), transformer);
  }
  
  public Map.Entry<K, V2> firstEntry()
  {
    return transformEntry(fromMap().firstEntry());
  }
  
  public Map.Entry<K, V2> floorEntry(K key)
  {
    return transformEntry(fromMap().floorEntry(key));
  }
  
  public K floorKey(K key)
  {
    return (K)fromMap().floorKey(key);
  }
  
  public NavigableMap<K, V2> headMap(K toKey)
  {
    return headMap(toKey, false);
  }
  
  public NavigableMap<K, V2> headMap(K toKey, boolean inclusive)
  {
    return Maps.transformEntries(fromMap().headMap(toKey, inclusive), transformer);
  }
  
  public Map.Entry<K, V2> higherEntry(K key)
  {
    return transformEntry(fromMap().higherEntry(key));
  }
  
  public K higherKey(K key)
  {
    return (K)fromMap().higherKey(key);
  }
  
  public Map.Entry<K, V2> lastEntry()
  {
    return transformEntry(fromMap().lastEntry());
  }
  
  public Map.Entry<K, V2> lowerEntry(K key)
  {
    return transformEntry(fromMap().lowerEntry(key));
  }
  
  public K lowerKey(K key)
  {
    return (K)fromMap().lowerKey(key);
  }
  
  public NavigableSet<K> navigableKeySet()
  {
    return fromMap().navigableKeySet();
  }
  
  public Map.Entry<K, V2> pollFirstEntry()
  {
    return transformEntry(fromMap().pollFirstEntry());
  }
  
  public Map.Entry<K, V2> pollLastEntry()
  {
    return transformEntry(fromMap().pollLastEntry());
  }
  
  public NavigableMap<K, V2> subMap(K fromKey, boolean fromInclusive, K toKey, boolean toInclusive)
  {
    return Maps.transformEntries(fromMap().subMap(fromKey, fromInclusive, toKey, toInclusive), transformer);
  }
  
  public NavigableMap<K, V2> subMap(K fromKey, K toKey)
  {
    return subMap(fromKey, true, toKey, false);
  }
  
  public NavigableMap<K, V2> tailMap(K fromKey)
  {
    return tailMap(fromKey, true);
  }
  
  public NavigableMap<K, V2> tailMap(K fromKey, boolean inclusive)
  {
    return Maps.transformEntries(fromMap().tailMap(fromKey, inclusive), transformer);
  }
  
  @Nullable
  private Map.Entry<K, V2> transformEntry(@Nullable Map.Entry<K, V1> entry)
  {
    return entry == null ? null : Maps.transformEntry(transformer, entry);
  }
  
  protected NavigableMap<K, V1> fromMap()
  {
    return (NavigableMap)super.fromMap();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.TransformedEntriesNavigableMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */