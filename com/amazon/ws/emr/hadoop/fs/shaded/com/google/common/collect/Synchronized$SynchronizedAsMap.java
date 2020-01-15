package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Synchronized$SynchronizedAsMap<K, V>
  extends Synchronized.SynchronizedMap<K, Collection<V>>
{
  transient Set<Map.Entry<K, Collection<V>>> asMapEntrySet;
  transient Collection<Collection<V>> asMapValues;
  private static final long serialVersionUID = 0L;
  
  Synchronized$SynchronizedAsMap(Map<K, Collection<V>> delegate, @Nullable Object mutex)
  {
    super(delegate, mutex);
  }
  
  public Collection<V> get(Object key)
  {
    synchronized (mutex)
    {
      Collection<V> collection = (Collection)super.get(key);
      return collection == null ? null : Synchronized.access$400(collection, mutex);
    }
  }
  
  public Set<Map.Entry<K, Collection<V>>> entrySet()
  {
    synchronized (mutex)
    {
      if (asMapEntrySet == null) {
        asMapEntrySet = new Synchronized.SynchronizedAsMapEntries(delegate().entrySet(), mutex);
      }
      return asMapEntrySet;
    }
  }
  
  public Collection<Collection<V>> values()
  {
    synchronized (mutex)
    {
      if (asMapValues == null) {
        asMapValues = new Synchronized.SynchronizedAsMapValues(delegate().values(), mutex);
      }
      return asMapValues;
    }
  }
  
  public boolean containsValue(Object o)
  {
    return values().contains(o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Synchronized.SynchronizedAsMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */