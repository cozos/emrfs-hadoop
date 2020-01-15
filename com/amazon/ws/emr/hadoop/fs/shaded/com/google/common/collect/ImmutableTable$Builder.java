package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.List;

public final class ImmutableTable$Builder<R, C, V>
{
  private final List<Table.Cell<R, C, V>> cells = Lists.newArrayList();
  private Comparator<? super R> rowComparator;
  private Comparator<? super C> columnComparator;
  
  public Builder<R, C, V> orderRowsBy(Comparator<? super R> rowComparator)
  {
    this.rowComparator = ((Comparator)Preconditions.checkNotNull(rowComparator));
    return this;
  }
  
  public Builder<R, C, V> orderColumnsBy(Comparator<? super C> columnComparator)
  {
    this.columnComparator = ((Comparator)Preconditions.checkNotNull(columnComparator));
    return this;
  }
  
  public Builder<R, C, V> put(R rowKey, C columnKey, V value)
  {
    cells.add(ImmutableTable.cellOf(rowKey, columnKey, value));
    return this;
  }
  
  public Builder<R, C, V> put(Table.Cell<? extends R, ? extends C, ? extends V> cell)
  {
    if ((cell instanceof Tables.ImmutableCell))
    {
      Preconditions.checkNotNull(cell.getRowKey());
      Preconditions.checkNotNull(cell.getColumnKey());
      Preconditions.checkNotNull(cell.getValue());
      
      Table.Cell<R, C, V> immutableCell = cell;
      cells.add(immutableCell);
    }
    else
    {
      put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }
    return this;
  }
  
  public Builder<R, C, V> putAll(Table<? extends R, ? extends C, ? extends V> table)
  {
    for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
      put(cell);
    }
    return this;
  }
  
  public ImmutableTable<R, C, V> build()
  {
    int size = cells.size();
    switch (size)
    {
    case 0: 
      return ImmutableTable.of();
    case 1: 
      return new SingletonImmutableTable((Table.Cell)Iterables.getOnlyElement(cells));
    }
    return RegularImmutableTable.forCells(cells, rowComparator, columnComparator);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableTable.Builder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */