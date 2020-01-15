package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;

class Maps$FilteredEntryMap$EntrySet$1
  extends TransformedIterator<Map.Entry<K, V>, Map.Entry<K, V>>
{
  Maps$FilteredEntryMap$EntrySet$1(Maps.FilteredEntryMap.EntrySet paramEntrySet, Iterator x0)
  {
    super(x0);
  }
  
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
        Preconditions.checkArgument(this$1.this$0.apply(getKey(), newValue));
        return (V)super.setValue(newValue);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Maps.FilteredEntryMap.EntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */