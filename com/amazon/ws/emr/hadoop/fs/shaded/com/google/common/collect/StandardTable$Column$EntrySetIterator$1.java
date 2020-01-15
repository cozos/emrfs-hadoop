package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;

class StandardTable$Column$EntrySetIterator$1
  extends AbstractMapEntry<R, V>
{
  StandardTable$Column$EntrySetIterator$1(StandardTable.Column.EntrySetIterator paramEntrySetIterator, Map.Entry paramEntry) {}
  
  public R getKey()
  {
    return (R)val$entry.getKey();
  }
  
  public V getValue()
  {
    return (V)((Map)val$entry.getValue()).get(this$2.this$1.columnKey);
  }
  
  public V setValue(V value)
  {
    return (V)((Map)val$entry.getValue()).put(this$2.this$1.columnKey, Preconditions.checkNotNull(value));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Column.EntrySetIterator.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */