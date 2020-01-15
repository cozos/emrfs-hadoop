package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class MapConstraints$ConstrainedMultimap<K, V>
  extends ForwardingMultimap<K, V>
  implements Serializable
{
  final MapConstraint<? super K, ? super V> constraint;
  final Multimap<K, V> delegate;
  transient Collection<Map.Entry<K, V>> entries;
  transient Map<K, Collection<V>> asMap;
  
  public MapConstraints$ConstrainedMultimap(Multimap<K, V> delegate, MapConstraint<? super K, ? super V> constraint)
  {
    this.delegate = ((Multimap)Preconditions.checkNotNull(delegate));
    this.constraint = ((MapConstraint)Preconditions.checkNotNull(constraint));
  }
  
  protected Multimap<K, V> delegate()
  {
    return delegate;
  }
  
  public Map<K, Collection<V>> asMap()
  {
    Map<K, Collection<V>> result = asMap;
    if (result == null)
    {
      final Map<K, Collection<V>> asMapDelegate = delegate.asMap();
      
      asMap = ( = new ForwardingMap()
      {
        Set<Map.Entry<K, Collection<V>>> entrySet;
        Collection<Collection<V>> values;
        
        protected Map<K, Collection<V>> delegate()
        {
          return asMapDelegate;
        }
        
        public Set<Map.Entry<K, Collection<V>>> entrySet()
        {
          Set<Map.Entry<K, Collection<V>>> result = entrySet;
          if (result == null) {
            entrySet = (result = MapConstraints.access$200(asMapDelegate.entrySet(), constraint));
          }
          return result;
        }
        
        public Collection<V> get(Object key)
        {
          try
          {
            Collection<V> collection = MapConstraints.ConstrainedMultimap.this.get(key);
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
      });
    }
    return result;
  }
  
  public Collection<Map.Entry<K, V>> entries()
  {
    Collection<Map.Entry<K, V>> result = entries;
    if (result == null) {
      entries = (result = MapConstraints.access$300(delegate.entries(), constraint));
    }
    return result;
  }
  
  public Collection<V> get(final K key)
  {
    Constraints.constrainedTypePreservingCollection(delegate.get(key), new Constraint()
    {
      public V checkElement(V value)
      {
        constraint.checkKeyValue(key, value);
        return value;
      }
    });
  }
  
  public boolean put(K key, V value)
  {
    constraint.checkKeyValue(key, value);
    return delegate.put(key, value);
  }
  
  public boolean putAll(K key, Iterable<? extends V> values)
  {
    return delegate.putAll(key, MapConstraints.access$400(key, values, constraint));
  }
  
  public boolean putAll(Multimap<? extends K, ? extends V> multimap)
  {
    boolean changed = false;
    for (Map.Entry<? extends K, ? extends V> entry : multimap.entries()) {
      changed |= put(entry.getKey(), entry.getValue());
    }
    return changed;
  }
  
  public Collection<V> replaceValues(K key, Iterable<? extends V> values)
  {
    return delegate.replaceValues(key, MapConstraints.access$400(key, values, constraint));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.MapConstraints.ConstrainedMultimap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */