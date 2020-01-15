package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

final class StandardTable$Row$RowEntrySet
  extends Maps.EntrySet<C, V>
{
  private StandardTable$Row$RowEntrySet(StandardTable.Row paramRow) {}
  
  Map<C, V> map()
  {
    return this$1;
  }
  
  public int size()
  {
    Map<C, V> map = this$1.backingRowMap();
    return map == null ? 0 : map.size();
  }
  
  public Iterator<Map.Entry<C, V>> iterator()
  {
    Map<C, V> map = this$1.backingRowMap();
    if (map == null) {
      return Iterators.emptyModifiableIterator();
    }
    final Iterator<Map.Entry<C, V>> iterator = map.entrySet().iterator();
    new Iterator()
    {
      public boolean hasNext()
      {
        return iterator.hasNext();
      }
      
      public Map.Entry<C, V> next()
      {
        final Map.Entry<C, V> entry = (Map.Entry)iterator.next();
        new ForwardingMapEntry()
        {
          protected Map.Entry<C, V> delegate()
          {
            return entry;
          }
          
          public V setValue(V value)
          {
            return (V)super.setValue(Preconditions.checkNotNull(value));
          }
          
          public boolean equals(Object object)
          {
            return standardEquals(object);
          }
        };
      }
      
      public void remove()
      {
        iterator.remove();
        this$1.maintainEmptyInvariant();
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Row.RowEntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */