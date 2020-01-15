package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedMultimap$1
  extends ForwardingMap<K, Collection<V>>
{
  Set<Map.Entry<K, Collection<V>>> entrySet;
  Collection<Collection<V>> values;
  
  MapConstraints$ConstrainedMultimap$1(MapConstraints.ConstrainedMultimap paramConstrainedMultimap, Map paramMap) {}
  
  protected Map<K, Collection<V>> delegate()
  {
    return val$asMapDelegate;
  }
  
  public Set<Map.Entry<K, Collection<V>>> entrySet()
  {
    Set<Map.Entry<K, Collection<V>>> result = entrySet;
    if (result == null) {
      entrySet = (result = MapConstraints.access$200(val$asMapDelegate.entrySet(), this$0.constraint));
    }
    return result;
  }
  
  public Collection<V> get(Object key)
  {
    try
    {
      Collection<V> collection = this$0.get(key);
      return collection.isEmpty() ? null : collection;
    }
    catch (ClassCastException e) {}
    return null;
  }
  
  public Collection<Collection<V>> values()
  {
    Collection<Collection<V>> result = values;
    if (result == null) {
      values = (result = new MapConstraints.ConstrainedAsMapValues(delegate().values(), entrySet()));
    }
    return result;
  }
  
  public boolean containsValue(Object o)
  {
    return values().contains(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedMultimap.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */