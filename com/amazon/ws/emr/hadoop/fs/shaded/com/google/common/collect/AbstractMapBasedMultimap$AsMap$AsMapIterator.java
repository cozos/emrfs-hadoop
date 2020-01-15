package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class AbstractMapBasedMultimap$AsMap$AsMapIterator
  implements Iterator<Map.Entry<K, Collection<V>>>
{
  final Iterator<Map.Entry<K, Collection<V>>> delegateIterator = this$1.submap.entrySet().iterator();
  Collection<V> collection;
  
  AbstractMapBasedMultimap$AsMap$AsMapIterator(AbstractMapBasedMultimap.AsMap paramAsMap) {}
  
  public boolean hasNext()
  {
    return delegateIterator.hasNext();
  }
  
  public Map.Entry<K, Collection<V>> next()
  {
    Map.Entry<K, Collection<V>> entry = (Map.Entry)delegateIterator.next();
    collection = ((Collection)entry.getValue());
    return this$1.wrapEntry(entry);
  }
  
  public void remove()
  {
    delegateIterator.remove();
    AbstractMapBasedMultimap.access$220(this$1.this$0, collection.size());
    collection.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.AsMap.AsMapIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */