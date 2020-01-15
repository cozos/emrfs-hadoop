package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map.Entry;

class StandardTable$Row$RowEntrySet$1
  implements Iterator<Map.Entry<C, V>>
{
  StandardTable$Row$RowEntrySet$1(StandardTable.Row.RowEntrySet paramRowEntrySet, Iterator paramIterator) {}
  
  public boolean hasNext()
  {
    return val$iterator.hasNext();
  }
  
  public Map.Entry<C, V> next()
  {
    final Map.Entry<C, V> entry = (Map.Entry)val$iterator.next();
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
    val$iterator.remove();
    this$2.this$1.maintainEmptyInvariant();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Row.RowEntrySet.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */