package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

final class RegularImmutableTable$CellSet
  extends ImmutableSet<Table.Cell<R, C, V>>
{
  private RegularImmutableTable$CellSet(RegularImmutableTable paramRegularImmutableTable) {}
  
  public int size()
  {
    return this$0.size();
  }
  
  public UnmodifiableIterator<Table.Cell<R, C, V>> iterator()
  {
    return asList().iterator();
  }
  
  ImmutableList<Table.Cell<R, C, V>> createAsList()
  {
    new ImmutableAsList()
    {
      public Table.Cell<R, C, V> get(int index)
      {
        return this$0.getCell(index);
      }
      
      ImmutableCollection<Table.Cell<R, C, V>> delegateCollection()
      {
        return RegularImmutableTable.CellSet.this;
      }
    };
  }
  
  public boolean contains(@Nullable Object object)
  {
    if ((object instanceof Table.Cell))
    {
      Table.Cell<?, ?, ?> cell = (Table.Cell)object;
      Object value = this$0.get(cell.getRowKey(), cell.getColumnKey());
      return (value != null) && (value.equals(cell.getValue()));
    }
    return false;
  }
  
  boolean isPartialView()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableTable.CellSet
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */