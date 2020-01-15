package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.AbstractMap;
import java.util.Collection;
import java.util.Map.Entry;
import java.util.Set;

@GwtCompatible
abstract class Maps$ImprovedAbstractMap<K, V>
  extends AbstractMap<K, V>
{
  private transient Set<Map.Entry<K, V>> entrySet;
  private transient Set<K> keySet;
  private transient Collection<V> values;
  
  abstract Set<Map.Entry<K, V>> createEntrySet();
  
  public Set<Map.Entry<K, V>> entrySet()
  {
    Set<Map.Entry<K, V>> result = entrySet;
    return result == null ? (entrySet = createEntrySet()) : result;
  }
  
  public Set<K> keySet()
  {
    Set<K> result = keySet;
    return result == null ? (keySet = createKeySet()) : result;
  }
  
  Set<K> createKeySet()
  {
    return new Maps.KeySet(this);
  }
  
  public Collection<V> values()
  {
    Collection<V> result = values;
    return result == null ? (values = createValues()) : result;
  }
  
  Collection<V> createValues()
  {
    return new Maps.Values(this);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.ImprovedAbstractMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */