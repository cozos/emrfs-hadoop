package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

abstract class AbstractMapBasedMultimap$Itr<T>
  implements Iterator<T>
{
  final Iterator<Map.Entry<K, Collection<V>>> keyIterator;
  K key;
  Collection<V> collection;
  Iterator<V> valueIterator;
  
  AbstractMapBasedMultimap$Itr(AbstractMapBasedMultimap paramAbstractMapBasedMultimap)
  {
    keyIterator = AbstractMapBasedMultimap.access$000(paramAbstractMapBasedMultimap).entrySet().iterator();
    key = null;
    collection = null;
    valueIterator = Iterators.emptyModifiableIterator();
  }
  
  abstract T output(K paramK, V paramV);
  
  public boolean hasNext()
  {
    return (keyIterator.hasNext()) || (valueIterator.hasNext());
  }
  
  public T next()
  {
    if (!valueIterator.hasNext())
    {
      Map.Entry<K, Collection<V>> mapEntry = (Map.Entry)keyIterator.next();
      key = mapEntry.getKey();
      collection = ((Collection)mapEntry.getValue());
      valueIterator = collection.iterator();
    }
    return (T)output(key, valueIterator.next());
  }
  
  public void remove()
  {
    valueIterator.remove();
    if (collection.isEmpty()) {
      keyIterator.remove();
    }
    AbstractMapBasedMultimap.access$210(this$0);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.Itr
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */