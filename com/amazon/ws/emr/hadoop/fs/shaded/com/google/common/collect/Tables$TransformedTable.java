package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

class Tables$TransformedTable<R, C, V1, V2>
  extends AbstractTable<R, C, V2>
{
  final Table<R, C, V1> fromTable;
  final Function<? super V1, V2> function;
  
  Tables$TransformedTable(Table<R, C, V1> fromTable, Function<? super V1, V2> function)
  {
    this.fromTable = ((Table)Preconditions.checkNotNull(fromTable));
    this.function = ((Function)Preconditions.checkNotNull(function));
  }
  
  public boolean contains(Object rowKey, Object columnKey)
  {
    return fromTable.contains(rowKey, columnKey);
  }
  
  public V2 get(Object rowKey, Object columnKey)
  {
    return (V2)(contains(rowKey, columnKey) ? function.apply(fromTable.get(rowKey, columnKey)) : null);
  }
  
  public int size()
  {
    return fromTable.size();
  }
  
  public void clear()
  {
    fromTable.clear();
  }
  
  public V2 put(R rowKey, C columnKey, V2 value)
  {
    throw new UnsupportedOperationException();
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V2> table)
  {
    throw new UnsupportedOperationException();
  }
  
  public V2 remove(Object rowKey, Object columnKey)
  {
    return (V2)(contains(rowKey, columnKey) ? function.apply(fromTable.remove(rowKey, columnKey)) : null);
  }
  
  public Map<C, V2> row(R rowKey)
  {
    return Maps.transformValues(fromTable.row(rowKey), function);
  }
  
  public Map<R, V2> column(C columnKey)
  {
    return Maps.transformValues(fromTable.column(columnKey), function);
  }
  
  Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>> cellFunction()
  {
    new Function()
    {
      public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> cell)
      {
        return Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), function.apply(cell.getValue()));
      }
    };
  }
  
  Iterator<Table.Cell<R, C, V2>> cellIterator()
  {
    return Iterators.transform(fromTable.cellSet().iterator(), cellFunction());
  }
  
  public Set<R> rowKeySet()
  {
    return fromTable.rowKeySet();
  }
  
  public Set<C> columnKeySet()
  {
    return fromTable.columnKeySet();
  }
  
  Collection<V2> createValues()
  {
    return Collections2.transform(fromTable.values(), function);
  }
  
  public Map<R, Map<C, V2>> rowMap()
  {
    Function<Map<C, V1>, Map<C, V2>> rowFunction = new Function()
    {
      public Map<C, V2> apply(Map<C, V1> row)
      {
        return Maps.transformValues(row, function);
      }
    };
    return Maps.transformValues(fromTable.rowMap(), rowFunction);
  }
  
  public Map<C, Map<R, V2>> columnMap()
  {
    Function<Map<R, V1>, Map<R, V2>> columnFunction = new Function()
    {
      public Map<R, V2> apply(Map<R, V1> column)
      {
        return Maps.transformValues(column, function);
      }
    };
    return Maps.transformValues(fromTable.columnMap(), columnFunction);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables.TransformedTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */