package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$ColumnKeyIterator
  extends AbstractIterator<C>
{
  final Map<C, V> seen = (Map)this$0.factory.get();
  final Iterator<Map<C, V>> mapIterator = this$0.backingMap.values().iterator();
  Iterator<Map.Entry<C, V>> entryIterator = Iterators.emptyIterator();
  
  private StandardTable$ColumnKeyIterator(StandardTable paramStandardTable) {}
  
  protected C computeNext()
  {
    for (;;)
    {
      if (entryIterator.hasNext())
      {
        Map.Entry<C, V> entry = (Map.Entry)entryIterator.next();
        if (!seen.containsKey(entry.getKey()))
        {
          seen.put(entry.getKey(), entry.getValue());
          return (C)entry.getKey();
        }
      }
      else
      {
        if (!mapIterator.hasNext()) {
          break;
        }
        entryIterator = ((Map)mapIterator.next()).entrySet().iterator();
      }
    }
    return (C)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.ColumnKeyIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */