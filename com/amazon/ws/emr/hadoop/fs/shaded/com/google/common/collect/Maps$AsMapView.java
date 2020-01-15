package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class Maps$AsMapView<K, V>
  extends Maps.ImprovedAbstractMap<K, V>
{
  private final Set<K> set;
  final Function<? super K, V> function;
  
  Set<K> backingSet()
  {
    return set;
  }
  
  Maps$AsMapView(Set<K> set, Function<? super K, V> function)
  {
    this.set = ((Set)Preconditions.checkNotNull(set));
    this.function = ((Function)Preconditions.checkNotNull(function));
  }
  
  public Set<K> createKeySet()
  {
    return Maps.access$200(backingSet());
  }
  
  Collection<V> createValues()
  {
    return Collections2.transform(set, function);
  }
  
  public int size()
  {
    return backingSet().size();
  }
  
  public boolean containsKey(@Nullable Object key)
  {
    return backingSet().contains(key);
  }
  
  public V get(@Nullable Object key)
  {
    if (Collections2.safeContains(backingSet(), key))
    {
      K k = (K)key;
      return (V)function.apply(k);
    }
    return null;
  }
  
  public V remove(@Nullable Object key)
  {
    if (backingSet().remove(key))
    {
      K k = (K)key;
      return (V)function.apply(k);
    }
    return null;
  }
  
  public void clear()
  {
    backingSet().clear();
  }
  
  protected Set<Map.Entry<K, V>> createEntrySet()
  {
    new Maps.EntrySet()
    {
      Map<K, V> map()
      {
        return Maps.AsMapView.this;
      }
      
      public Iterator<Map.Entry<K, V>> iterator()
      {
        return Maps.asMapEntryIterator(backingSet(), function);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.AsMapView
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */