package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.AbstractCollection;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

@GwtCompatible
abstract class AbstractTable<R, C, V>
  implements Table<R, C, V>
{
  private transient Set<Table.Cell<R, C, V>> cellSet;
  private transient Collection<V> values;
  
  public boolean containsRow(@Nullable Object rowKey)
  {
    return Maps.safeContainsKey(rowMap(), rowKey);
  }
  
  public boolean containsColumn(@Nullable Object columnKey)
  {
    return Maps.safeContainsKey(columnMap(), columnKey);
  }
  
  public Set<R> rowKeySet()
  {
    return rowMap().keySet();
  }
  
  public Set<C> columnKeySet()
  {
    return columnMap().keySet();
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    for (Map<C, V> row : rowMap().values()) {
      if (row.containsValue(value)) {
        return true;
      }
    }
    return false;
  }
  
  public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    Map<C, V> row = (Map)Maps.safeGet(rowMap(), rowKey);
    return (row != null) && (Maps.safeContainsKey(row, columnKey));
  }
  
  public V get(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    Map<C, V> row = (Map)Maps.safeGet(rowMap(), rowKey);
    return row == null ? null : Maps.safeGet(row, columnKey);
  }
  
  public boolean isEmpty()
  {
    return size() == 0;
  }
  
  public void clear()
  {
    Iterators.clear(cellSet().iterator());
  }
  
  public V remove(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    Map<C, V> row = (Map)Maps.safeGet(rowMap(), rowKey);
    return row == null ? null : Maps.safeRemove(row, columnKey);
  }
  
  public V put(R rowKey, C columnKey, V value)
  {
    return (V)row(rowKey).put(columnKey, value);
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V> table)
  {
    for (Table.Cell<? extends R, ? extends C, ? extends V> cell : table.cellSet()) {
      put(cell.getRowKey(), cell.getColumnKey(), cell.getValue());
    }
  }
  
  public Set<Table.Cell<R, C, V>> cellSet()
  {
    Set<Table.Cell<R, C, V>> result = cellSet;
    return result == null ? (cellSet = createCellSet()) : result;
  }
  
  Set<Table.Cell<R, C, V>> createCellSet()
  {
    return new CellSet();
  }
  
  abstract Iterator<Table.Cell<R, C, V>> cellIterator();
  
  class CellSet
    extends AbstractSet<Table.Cell<R, C, V>>
  {
    CellSet() {}
    
    public boolean contains(Object o)
    {
      if ((o instanceof Table.Cell))
      {
        Table.Cell<?, ?, ?> cell = (Table.Cell)o;
        Map<C, V> row = (Map)Maps.safeGet(rowMap(), cell.getRowKey());
        return (row != null) && (Collections2.safeContains(row.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue())));
      }
      return false;
    }
    
    public boolean remove(@Nullable Object o)
    {
      if ((o instanceof Table.Cell))
      {
        Table.Cell<?, ?, ?> cell = (Table.Cell)o;
        Map<C, V> row = (Map)Maps.safeGet(rowMap(), cell.getRowKey());
        return (row != null) && (Collections2.safeRemove(row.entrySet(), Maps.immutableEntry(cell.getColumnKey(), cell.getValue())));
      }
      return false;
    }
    
    public void clear()
    {
      AbstractTable.this.clear();
    }
    
    public Iterator<Table.Cell<R, C, V>> iterator()
    {
      return cellIterator();
    }
    
    public int size()
    {
      return AbstractTable.this.size();
    }
  }
  
  public Collection<V> values()
  {
    Collection<V> result = values;
    return result == null ? (values = createValues()) : result;
  }
  
  Collection<V> createValues()
  {
    return new Values();
  }
  
  Iterator<V> valuesIterator()
  {
    new TransformedIterator(cellSet().iterator())
    {
      V transform(Table.Cell<R, C, V> cell)
      {
        return (V)cell.getValue();
      }
    };
  }
  
  class Values
    extends AbstractCollection<V>
  {
    Values() {}
    
    public Iterator<V> iterator()
    {
      return valuesIterator();
    }
    
    public boolean contains(Object o)
    {
      return containsValue(o);
    }
    
    public void clear()
    {
      AbstractTable.this.clear();
    }
    
    public int size()
    {
      return AbstractTable.this.size();
    }
  }
  
  public boolean equals(@Nullable Object obj)
  {
    return Tables.equalsImpl(this, obj);
  }
  
  public int hashCode()
  {
    return cellSet().hashCode();
  }
  
  public String toString()
  {
    return rowMap().toString();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.AbstractTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */