package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMapBasedMultimap$KeySet$1
  implements Iterator<K>
{
  Map.Entry<K, Collection<V>> entry;
  
  AbstractMapBasedMultimap$KeySet$1(AbstractMapBasedMultimap.KeySet paramKeySet, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$entryIterator.hasNext();
  }
  
  public K next()
  {
    entry = ((Map.Entry)val$entryIterator.next());
    return (K)entry.getKey();
  }
  
  public void remove()
  {
    CollectPreconditions.checkRemove(entry != null);
    Collection<V> collection = (Collection)entry.getValue();
    val$entryIterator.remove();
    AbstractMapBasedMultimap.access$220(this$1.this$0, collection.size());
    collection.clear();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMapBasedMultimap.KeySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */