package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Tables$TransposeTable<C, R, V>
  extends AbstractTable<C, R, V>
{
  final Table<R, C, V> original;
  
  Tables$TransposeTable(Table<R, C, V> original)
  {
    this.original = ((Table)Preconditions.checkNotNull(original));
  }
  
  public void clear()
  {
    original.clear();
  }
  
  public Map<C, V> column(R columnKey)
  {
    return original.row(columnKey);
  }
  
  public Set<R> columnKeySet()
  {
    return original.rowKeySet();
  }
  
  public Map<R, Map<C, V>> columnMap()
  {
    return original.rowMap();
  }
  
  public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return original.contains(columnKey, rowKey);
  }
  
  public boolean containsColumn(@Nullable Object columnKey)
  {
    return original.containsRow(columnKey);
  }
  
  public boolean containsRow(@Nullable Object rowKey)
  {
    return original.containsColumn(rowKey);
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return original.containsValue(value);
  }
  
  public V get(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return (V)original.get(columnKey, rowKey);
  }
  
  public V put(C rowKey, R columnKey, V value)
  {
    return (V)original.put(columnKey, rowKey, value);
  }
  
  public void putAll(Table<? extends C, ? extends R, ? extends V> table)
  {
    original.putAll(Tables.transpose(table));
  }
  
  public V remove(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return (V)original.remove(columnKey, rowKey);
  }
  
  public Map<R, V> row(C rowKey)
  {
    return original.column(rowKey);
  }
  
  public Set<C> rowKeySet()
  {
    return original.columnKeySet();
  }
  
  public Map<C, Map<R, V>> rowMap()
  {
    return original.columnMap();
  }
  
  public int size()
  {
    return original.size();
  }
  
  public Collection<V> values()
  {
    return original.values();
  }
  
  private static final Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>> TRANSPOSE_CELL = new Function()
  {
    public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> cell)
    {
      return Tables.immutableCell(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
    }
  };
  
  Iterator<Table.Cell<C, R, V>> cellIterator()
  {
    return Iterators.transform(original.cellSet().iterator(), TRANSPOSE_CELL);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables.TransposeTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */