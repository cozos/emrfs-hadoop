package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import javax.annotation.Nullable;

class AbstractTable$CellSet
  extends AbstractSet<Table.Cell<R, C, V>>
{
  AbstractTable$CellSet(AbstractTable paramAbstractTable) {}
  
  public boolean contains(Object o)
  {
    if ((o instanceof Table.Cell))
    {
      Table.Cell<?, ?, ?> cell = (Table.Cell)o;
      Map<C, V> row = (Map)Maps.safeGet(this$0.rowMap(), cell.getRowKey());
      return (row != null) && (Collections2.safeContains(row.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue())));
    }
    return false;
  }
  
  public boolean remove(@Nullable Object o)
  {
    if ((o instanceof Table.Cell))
    {
      Table.Cell<?, ?, ?> cell = (Table.Cell)o;
      Map<C, V> row = (Map)Maps.safeGet(this$0.rowMap(), cell.getRowKey());
      return (row != null) && (Collections2.safeRemove(row.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue())));
    }
    return false;
  }
  
  public void clear()
  {
    this$0.clear();
  }
  
  public Iterator<Table.Cell<R, C, V>> iterator()
  {
    return this$0.cellIterator();
  }
  
  public int size()
  {
    return this$0.size();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractTable.CellSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */