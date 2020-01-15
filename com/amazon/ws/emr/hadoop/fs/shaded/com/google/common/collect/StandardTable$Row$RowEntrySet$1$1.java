package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map.Entry;

class StandardTable$Row$RowEntrySet$1$1
  extends ForwardingMapEntry<C, V>
{
  StandardTable$Row$RowEntrySet$1$1(StandardTable.Row.RowEntrySet.1 param1, Map.Entry paramEntry) {}
  
  protected Map.Entry<C, V> delegate()
  {
    return val$entry;
  }
  
  public V setValue(V value)
  {
    return (V)super.setValue(Preconditions.checkNotNull(value));
  }
  
  public boolean equals(Object object)
  {
    return standardEquals(object);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Row.RowEntrySet.1.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */