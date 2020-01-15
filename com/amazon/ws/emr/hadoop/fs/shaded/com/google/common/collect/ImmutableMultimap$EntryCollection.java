package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map.Entry;

class ImmutableMultimap$EntryCollection<K, V>
  extends ImmutableCollection<Map.Entry<K, V>>
{
  final ImmutableMultimap<K, V> multimap;
  private static final long serialVersionUID = 0L;
  
  ImmutableMultimap$EntryCollection(ImmutableMultimap<K, V> multimap)
  {
    this.multimap = multimap;
  }
  
  public UnmodifiableIterator<Map.Entry<K, V>> iterator()
  {
    return multimap.entryIterator();
  }
  
  boolean isPartialView()
  {
    return multimap.isPartialView();
  }
  
  public int size()
  {
    return multimap.size();
  }
  
  public boolean contains(Object object)
  {
    if ((object instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)object;
      return multimap.containsEntry(entry.getKey(), entry.getValue());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableMultimap.EntryCollection
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */