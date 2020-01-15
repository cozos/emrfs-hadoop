package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class Multimaps$Keys$KeysEntrySet
  extends Multisets.EntrySet<K>
{
  Multimaps$Keys$KeysEntrySet(Multimaps.Keys paramKeys) {}
  
  Multiset<K> multiset()
  {
    return this$0;
  }
  
  public Iterator<Multiset.Entry<K>> iterator()
  {
    return this$0.entryIterator();
  }
  
  public int size()
  {
    return this$0.distinctElements();
  }
  
  public boolean isEmpty()
  {
    return this$0.multimap.isEmpty();
  }
  
  public boolean contains(@Nullable Object o)
  {
    if ((o instanceof Multiset.Entry))
    {
      Multiset.Entry<?> entry = (Multiset.Entry)o;
      Collection<V> collection = (Collection)this$0.multimap.asMap().get(entry.getElement());
      return (collection != null) && (collection.size() == entry.getCount());
    }
    return false;
  }
  
  public boolean remove(@Nullable Object o)
  {
    if ((o instanceof Multiset.Entry))
    {
      Multiset.Entry<?> entry = (Multiset.Entry)o;
      Collection<V> collection = (Collection)this$0.multimap.asMap().get(entry.getElement());
      if ((collection != null) && (collection.size() == entry.getCount()))
      {
        collection.clear();
        return true;
      }
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Multimaps.Keys.KeysEntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */