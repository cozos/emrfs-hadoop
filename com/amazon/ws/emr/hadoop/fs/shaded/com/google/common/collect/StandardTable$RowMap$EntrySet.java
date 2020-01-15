package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$RowMap$EntrySet
  extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>>
{
  StandardTable$RowMap$EntrySet(StandardTable.RowMap paramRowMap)
  {
    super(this$0, null);
  }
  
  public Iterator<Map.Entry<R, Map<C, V>>> iterator()
  {
    Maps.asMapEntryIterator(this$1.this$0.backingMap.keySet(), new Function()
    {
      public Map<C, V> apply(R rowKey)
      {
        return this$1.this$0.row(rowKey);
      }
    });
  }
  
  public int size()
  {
    return this$1.this$0.backingMap.size();
  }
  
  public boolean contains(Object obj)
  {
    if ((obj instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)obj;
      return (entry.getKey() != null) && ((entry.getValue() instanceof Map)) && (Collections2.safeContains(this$1.this$0.backingMap.entrySet(), entry));
    }
    return false;
  }
  
  public boolean remove(Object obj)
  {
    if ((obj instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)obj;
      return (entry.getKey() != null) && ((entry.getValue() instanceof Map)) && (this$1.this$0.backingMap.entrySet().remove(entry));
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.RowMap.EntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */