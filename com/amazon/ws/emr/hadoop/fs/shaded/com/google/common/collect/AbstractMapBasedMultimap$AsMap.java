package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$AsMap
  extends Maps.ImprovedAbstractMap<K, Collection<V>>
{
  final transient Map<K, Collection<V>> submap;
  
  AbstractMapBasedMultimap$AsMap(Map<K, Collection<V>> arg1)
  {
    this.submap = submap;
  }
  
  protected Set<Map.Entry<K, Collection<V>>> createEntrySet()
  {
    return new AsMapEntries();
  }
  
  public boolean containsKey(Object key)
  {
    return Maps.safeContainsKey(submap, key);
  }
  
  public Collection<V> get(Object key)
  {
    Collection<V> collection = (Collection)Maps.safeGet(submap, key);
    if (collection == null) {
      return null;
    }
    K k = (K)key;
    return this$0.wrapCollection(k, collection);
  }
  
  public Set<K> keySet()
  {
    return this$0.keySet();
  }
  
  public int size()
  {
    return submap.size();
  }
  
  public Collection<V> remove(Object key)
  {
    Collection<V> collection = (Collection)submap.remove(key);
    if (collection == null) {
      return null;
    }
    Collection<V> output = this$0.createCollection();
    output.addAll(collection);
    AbstractMapBasedMultimap.access$220(this$0, collection.size());
    collection.clear();
    return output;
  }
  
  public boolean equals(@Nullable Object object)
  {
    return (this == object) || (submap.equals(object));
  }
  
  public int hashCode()
  {
    return submap.hashCode();
  }
  
  public String toString()
  {
    return submap.toString();
  }
  
  public void clear()
  {
    if (submap == AbstractMapBasedMultimap.access$000(this$0)) {
      this$0.clear();
    } else {
      Iterators.clear(new AsMapIterator());
    }
  }
  
  Map.Entry<K, Collection<V>> wrapEntry(Map.Entry<K, Collection<V>> entry)
  {
    K key = entry.getKey();
    return Maps.immutableEntry(key, this$0.wrapCollection(key, (Collection)entry.getValue()));
  }
  
  class AsMapEntries
    extends Maps.EntrySet<K, Collection<V>>
  {
    AsMapEntries() {}
    
    Map<K, Collection<V>> map()
    {
      return AbstractMapBasedMultimap.AsMap.this;
    }
    
    public Iterator<Map.Entry<K, Collection<V>>> iterator()
    {
      return new AbstractMapBasedMultimap.AsMap.AsMapIterator(AbstractMapBasedMultimap.AsMap.this);
    }
    
    public boolean contains(Object o)
    {
      return Collections2.safeContains(submap.entrySet(), o);
    }
    
    public boolean remove(Object o)
    {
      if (!contains(o)) {
        return false;
      }
      Map.Entry<?, ?> entry = (Map.Entry)o;
      AbstractMapBasedMultimap.access$400(this$0, entry.getKey());
      return true;
    }
  }
  
  class AsMapIterator
    implements Iterator<Map.Entry<K, Collection<V>>>
  {
    final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = submap.entrySet().iterator();
    Collection<V> collection;
    
    AsMapIterator() {}
    
    public boolean hasNext()
    {
      return delegateIterator.hasNext();
    }
    
    public Map.Entry<K, Collection<V>> next()
    {
      Map.Entry<K, Collection<V>> entry = (Map.Entry)delegateIterator.next();
      collection = ((Collection)entry.getValue());
      return wrapEntry(entry);
    }
    
    public void remove()
    {
      delegateIterator.remove();
      AbstractMapBasedMultimap.access$220(this$0, collection.size());
      collection.clear();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.AsMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */