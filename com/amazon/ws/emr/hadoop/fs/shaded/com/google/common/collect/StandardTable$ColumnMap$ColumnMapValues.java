package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$ColumnMap$ColumnMapValues
  extends Maps.Values<C, Map<R, V>>
{
  StandardTable$ColumnMap$ColumnMapValues(StandardTable.ColumnMap paramColumnMap)
  {
    super(paramColumnMap);
  }
  
  public boolean remove(Object obj)
  {
    for (Map.Entry<C, Map<R, V>> entry : this$1.entrySet()) {
      if (((Map)entry.getValue()).equals(obj))
      {
        StandardTable.access$1000(this$1.this$0, entry.getKey());
        return true;
      }
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> c)
  {
    Preconditions.checkNotNull(c);
    boolean changed = false;
    for (C columnKey : Lists.newArrayList(this$1.this$0.columnKeySet().iterator())) {
      if (c.contains(this$1.this$0.column(columnKey)))
      {
        StandardTable.access$1000(this$1.this$0, columnKey);
        changed = true;
      }
    }
    return changed;
  }
  
  public boolean retainAll(Collection<?> c)
  {
    Preconditions.checkNotNull(c);
    boolean changed = false;
    for (C columnKey : Lists.newArrayList(this$1.this$0.columnKeySet().iterator())) {
      if (!c.contains(this$1.this$0.column(columnKey)))
      {
        StandardTable.access$1000(this$1.this$0, columnKey);
        changed = true;
      }
    }
    return changed;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.ColumnMap.ColumnMapValues
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */