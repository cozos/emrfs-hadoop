package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$Column$EntrySetIterator
  extends AbstractIterator<Map.Entry<R, V>>
{
  final Iterator<Map.Entry<R, Map<C, V>>> iterator = this$1.this$0.backingMap.entrySet().iterator();
  
  private StandardTable$Column$EntrySetIterator(StandardTable.Column paramColumn) {}
  
  protected Map.Entry<R, V> computeNext()
  {
    while (iterator.hasNext())
    {
      final Map.Entry<R, Map<C, V>> entry = (Map.Entry)iterator.next();
      if (((Map)entry.getValue()).containsKey(this$1.columnKey)) {
        new AbstractMapEntry()
        {
          public R getKey()
          {
            return (R)entry.getKey();
          }
          
          public V getValue()
          {
            return (V)((Map)entry.getValue()).get(this$1.columnKey);
          }
          
          public V setValue(V value)
          {
            return (V)((Map)entry.getValue()).put(this$1.columnKey, Preconditions.checkNotNull(value));
          }
        };
      }
    }
    return (Map.Entry)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.Column.EntrySetIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */