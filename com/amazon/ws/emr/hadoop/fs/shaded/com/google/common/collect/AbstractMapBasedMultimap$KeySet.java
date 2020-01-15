package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

class AbstractMapBasedMultimap$KeySet
  extends Maps.KeySet<K, Collection<V>>
{
  AbstractMapBasedMultimap$KeySet(Map<K, Collection<V>> arg1)
  {
    super(subMap);
  }
  
  public Iterator<K> iterator()
  {
    final Iterator<Map.Entry<K, Collection<V>>> entryIterator = map().entrySet().iterator();
    
    new Iterator()
    {
      Map.Entry<K, Collection<V>> entry;
      
      public boolean hasNext()
      {
        return entryIterator.hasNext();
      }
      
      public K next()
      {
        entry = ((Map.Entry)entryIterator.next());
        return (K)entry.getKey();
      }
      
      public void remove()
      {
        CollectPreconditions.checkRemove(entry != null);
        Collection<V> collection = (Collection)entry.getValue();
        entryIterator.remove();
        AbstractMapBasedMultimap.access$220(this$0, collection.size());
        collection.clear();
      }
    };
  }
  
  public boolean remove(Object key)
  {
    int count = 0;
    Collection<V> collection = (Collection)map().remove(key);
    if (collection != null)
    {
      count = collection.size();
      collection.clear();
      AbstractMapBasedMultimap.access$220(this$0, count);
    }
    return count > 0;
  }
  
  public void clear()
  {
    Iterators.clear(iterator());
  }
  
  public boolean containsAll(Collection<?> c)
  {
    return map().keySet().containsAll(c);
  }
  
  public boolean equals(@Nullable Object object)
  {
    return (this == object) || (map().keySet().equals(object));
  }
  
  public int hashCode()
  {
    return map().keySet().hashCode();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.KeySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */