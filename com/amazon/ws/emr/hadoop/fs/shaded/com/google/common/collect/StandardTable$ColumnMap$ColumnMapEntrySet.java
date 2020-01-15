package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$ColumnMap$ColumnMapEntrySet
  extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>>
{
  StandardTable$ColumnMap$ColumnMapEntrySet(StandardTable.ColumnMap paramColumnMap)
  {
    super(this$0, null);
  }
  
  public Iterator<Map.Entry<C, Map<R, V>>> iterator()
  {
    Maps.asMapEntryIterator(this$1.this$0.columnKeySet(), new Function()
    {
      public Map<R, V> apply(C columnKey)
      {
        return this$1.this$0.column(columnKey);
      }
    });
  }
  
  public int size()
  {
    return this$1.this$0.columnKeySet().size();
  }
  
  public boolean contains(Object obj)
  {
    if ((obj instanceof Map.Entry))
    {
      Map.Entry<?, ?> entry = (Map.Entry)obj;
      if (this$1.this$0.containsColumn(entry.getKey()))
      {
        C columnKey = entry.getKey();
        return this$1.get(columnKey).equals(entry.getValue());
      }
    }
    return false;
  }
  
  public boolean remove(Object obj)
  {
    if (contains(obj))
    {
      Map.Entry<?, ?> entry = (Map.Entry)obj;
      StandardTable.access$1000(this$1.this$0, entry.getKey());
      return true;
    }
    return false;
  }
  
  public boolean removeAll(Collection<?> c)
  {
    Preconditions.checkNotNull(c);
    return Sets.removeAllImpl(this, c.iterator());
  }
  
  public boolean retainAll(Collection<?> c)
  {
    Preconditions.checkNotNull(c);
    boolean changed = false;
    for (C columnKey : Lists.newArrayList(this$1.this$0.columnKeySet().iterator())) {
      if (!c.contains(Maps.immutableEntry(columnKey, this$1.this$0.column(columnKey))))
      {
        StandardTable.access$1000(this$1.this$0, columnKey);
        changed = true;
      }
    }
    return changed;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.ColumnMap.ColumnMapEntrySet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */