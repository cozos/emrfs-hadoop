package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

class Maps$FilteredEntryMap$EntrySet
  extends ForwardingSet<Map.Entry<K, V>>
{
  private Maps$FilteredEntryMap$EntrySet(Maps.FilteredEntryMap paramFilteredEntryMap) {}
  
  protected Set<Map.Entry<K, V>> delegate()
  {
    return this$0.filteredEntrySet;
  }
  
  public Iterator<Map.Entry<K, V>> iterator()
  {
    new TransformedIterator(this$0.filteredEntrySet.iterator())
    {
      Map.Entry<K, V> transform(final Map.Entry<K, V> entry)
      {
        new ForwardingMapEntry()
        {
          protected Map.Entry<K, V> delegate()
          {
            return entry;
          }
          
          public V setValue(V newValue)
          {
            Preconditions.checkArgument(this$0.apply(getKey(), newValue));
            return (V)super.setValue(newValue);
          }
        };
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntryMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */