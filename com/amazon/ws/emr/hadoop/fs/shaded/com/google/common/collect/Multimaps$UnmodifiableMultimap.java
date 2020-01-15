package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class Multimaps$UnmodifiableMultimap<K, V>
  extends ForwardingMultimap<K, V>
  implements Serializable
{
  final Multimap<K, V> delegate;
  transient Collection<Map.Entry<K, V>> entries;
  transient Multiset<K> keys;
  transient Set<K> keySet;
  transient Collection<V> values;
  transient Map<K, Collection<V>> map;
  private static final long serialVersionUID = 0L;
  
  Multimaps$UnmodifiableMultimap(Multimap<K, V> delegate)
  {
    this.delegate = ((Multimap)Preconditions.checkNotNull(delegate));
  }
  
  protected Multimap<K, V> delegate()
  {
    return delegate;
  }
  
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<K, Collection<V>> asMap()
  {
    Map<K, Collection<V>> result = map;
    if (result == null) {
      result =  = Collections.unmodifiableMap(Maps.transformValues(delegate.asMap(), new Function()
      {
        public Collection<V> apply(Collection<V> collection)
        {
          return Multimaps.access$000(collection);
        }
      }));
    }
    return result;
  }
  
  public Collection<Map.Entry<K, V>> entries()
  {
    Collection<Map.Entry<K, V>> result = entries;
    if (result == null) {
      entries = (result = Multimaps.access$100(delegate.entries()));
    }
    return result;
  }
  
  public Collection<V> get(K key)
  {
    return Multimaps.access$000(delegate.get(key));
  }
  
  public Multiset<K> keys()
  {
    Multiset<K> result = keys;
    if (result == null) {
      keys = (result = Multisets.unmodifiableMultiset(delegate.keys()));
    }
    return result;
  }
  
  public Set<K> keySet()
  {
    Set<K> result = keySet;
    if (result == null) {
      keySet = (result = Collections.unmodifiableSet(delegate.keySet()));
    }
    return result;
  }
  
  public boolean put(K key, V value)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(K key, Iterable<? extends V> values)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean putAll(Multimap<? extends K, ? extends V> multimap)
  {
    throw new UnsupportedOperationException();
  }
  
  public boolean remove(Object key, Object value)
  {
    throw new UnsupportedOperationException();
  }
  
  public Collection<V> removeAll(Object key)
  {
    throw new UnsupportedOperationException();
  }
  
  public Collection<V> replaceValues(K key, Iterable<? extends V> values)
  {
    throw new UnsupportedOperationException();
  }
  
  public Collection<V> values()
  {
    Collection<V> result = values;
    if (result == null) {
      values = (result = Collections.unmodifiableCollection(delegate.values()));
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.UnmodifiableMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */