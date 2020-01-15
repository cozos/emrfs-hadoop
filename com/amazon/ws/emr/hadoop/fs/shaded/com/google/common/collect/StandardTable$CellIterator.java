package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class StandardTable$CellIterator
  implements Iterator<Table.Cell<R, C, V>>
{
  final Iterator<Map.Entry<R, Map<C, V>>> rowIterator = this$0.backingMap.entrySet().iterator();
  Map.Entry<R, Map<C, V>> rowEntry;
  Iterator<Map.Entry<C, V>> columnIterator = Iterators.emptyModifiableIterator();
  
  private StandardTable$CellIterator(StandardTable paramStandardTable) {}
  
  public boolean hasNext()
  {
    return (rowIterator.hasNext()) || (columnIterator.hasNext());
  }
  
  public Table.Cell<R, C, V> next()
  {
    if (!columnIterator.hasNext())
    {
      rowEntry = ((Map.Entry)rowIterator.next());
      columnIterator = ((Map)rowEntry.getValue()).entrySet().iterator();
    }
    Map.Entry<C, V> columnEntry = (Map.Entry)columnIterator.next();
    return Tables.immutableCell(rowEntry.getKey(), columnEntry.getKey(), columnEntry.getValue());
  }
  
  public void remove()
  {
    columnIterator.remove();
    if (((Map)rowEntry.getValue()).isEmpty()) {
      rowIterator.remove();
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardTable.CellIterator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */