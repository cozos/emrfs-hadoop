package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map.Entry;

class AbstractMultimap$Entries
  extends Multimaps.Entries<K, V>
{
  private AbstractMultimap$Entries(AbstractMultimap paramAbstractMultimap) {}
  
  Multimap<K, V> multimap()
  {
    return this$0;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    return this$0.entryIterator();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractMultimap.Entries
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */