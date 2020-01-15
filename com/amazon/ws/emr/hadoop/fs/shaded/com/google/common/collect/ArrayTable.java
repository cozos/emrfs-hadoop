package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtIncompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import javax.annotation.Nullable;

@Beta
@GwtCompatible(emulated=true)
public final class ArrayTable<R, C, V>
  extends AbstractTable<R, C, V>
  implements Serializable
{
  private final ImmutableList<R> rowList;
  private final ImmutableList<C> columnList;
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  private final V[][] array;
  private transient ArrayTable<R, C, V>.ColumnMap columnMap;
  private transient ArrayTable<R, C, V>.RowMap rowMap;
  private static final long serialVersionUID = 0L;
  
  public static <R, C, V> ArrayTable<R, C, V> create(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys)
  {
    return new ArrayTable(rowKeys, columnKeys);
  }
  
  public static <R, C, V> ArrayTable<R, C, V> create(Table<R, C, V> table)
  {
    return (table instanceof ArrayTable) ? new ArrayTable((ArrayTable)table) : new ArrayTable(table);
  }
  
  private ArrayTable(Iterable<? extends R> rowKeys, Iterable<? extends C> columnKeys)
  {
    rowList = ImmutableList.copyOf(rowKeys);
    columnList = ImmutableList.copyOf(columnKeys);
    Preconditions.checkArgument(!rowList.isEmpty());
    Preconditions.checkArgument(!columnList.isEmpty());
    
    rowKeyToIndex = index(rowList);
    columnKeyToIndex = index(columnList);
    
    V[][] tmpArray = (Object[][])new Object[rowList.size()][columnList.size()];
    
    array = tmpArray;
    
    eraseAll();
  }
  
  private static <E> ImmutableMap<E, Integer> index(List<E> list)
  {
    ImmutableMap.Builder<E, Integer> columnBuilder = ImmutableMap.builder();
    for (int i = 0; i < list.size(); i++) {
      columnBuilder.put(list.get(i), Integer.valueOf(i));
    }
    return columnBuilder.build();
  }
  
  private ArrayTable(Table<R, C, V> table)
  {
    this(table.rowKeySet(), table.columnKeySet());
    putAll(table);
  }
  
  private ArrayTable(ArrayTable<R, C, V> table)
  {
    rowList = rowList;
    columnList = columnList;
    rowKeyToIndex = rowKeyToIndex;
    columnKeyToIndex = columnKeyToIndex;
    
    V[][] copy = (Object[][])new Object[rowList.size()][columnList.size()];
    array = copy;
    
    eraseAll();
    for (int i = 0; i < rowList.size(); i++) {
      System.arraycopy(array[i], 0, copy[i], 0, array[i].length);
    }
  }
  
  private static abstract class ArrayMap<K, V>
    extends Maps.ImprovedAbstractMap<K, V>
  {
    private final ImmutableMap<K, Integer> keyIndex;
    
    private ArrayMap(ImmutableMap<K, Integer> keyIndex)
    {
      this.keyIndex = keyIndex;
    }
    
    public Set<K> keySet()
    {
      return keyIndex.keySet();
    }
    
    K getKey(int index)
    {
      return (K)keyIndex.keySet().asList().get(index);
    }
    
    abstract String getKeyRole();
    
    @Nullable
    abstract V getValue(int paramInt);
    
    @Nullable
    abstract V setValue(int paramInt, V paramV);
    
    public int size()
    {
      return keyIndex.size();
    }
    
    public boolean isEmpty()
    {
      return keyIndex.isEmpty();
    }
    
    protected Set<Map.Entry<K, V>> createEntrySet()
    {
      new Maps.EntrySet()
      {
        Map<K, V> map()
        {
          return ArrayTable.ArrayMap.this;
        }
        
        public Iterator<Map.Entry<K, V>> iterator()
        {
          new AbstractIndexedListIterator(size())
          {
            protected Map.Entry<K, V> get(final int index)
            {
              new AbstractMapEntry()
              {
                public K getKey()
                {
                  return (K)getKey(index);
                }
                
                public V getValue()
                {
                  return (V)getValue(index);
                }
                
                public V setValue(V value)
                {
                  return (V)setValue(index, value);
                }
              };
            }
          };
        }
      };
    }
    
    public boolean containsKey(@Nullable Object key)
    {
      return keyIndex.containsKey(key);
    }
    
    public V get(@Nullable Object key)
    {
      Integer index = (Integer)keyIndex.get(key);
      if (index == null) {
        return null;
      }
      return (V)getValue(index.intValue());
    }
    
    public V put(K key, V value)
    {
      Integer index = (Integer)keyIndex.get(key);
      if (index == null)
      {
        String str1 = String.valueOf(String.valueOf(getKeyRole()));String str2 = String.valueOf(String.valueOf(key));String str3 = String.valueOf(String.valueOf(keyIndex.keySet()));throw new IllegalArgumentException(9 + str1.length() + str2.length() + str3.length() + str1 + " " + str2 + " not in " + str3);
      }
      return (V)setValue(index.intValue(), value);
    }
    
    public V remove(Object key)
    {
      throw new UnsupportedOperationException();
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public ImmutableList<R> rowKeyList()
  {
    return rowList;
  }
  
  public ImmutableList<C> columnKeyList()
  {
    return columnList;
  }
  
  public V at(int rowIndex, int columnIndex)
  {
    Preconditions.checkElementIndex(rowIndex, rowList.size());
    Preconditions.checkElementIndex(columnIndex, columnList.size());
    return (V)array[rowIndex][columnIndex];
  }
  
  public V set(int rowIndex, int columnIndex, @Nullable V value)
  {
    Preconditions.checkElementIndex(rowIndex, rowList.size());
    Preconditions.checkElementIndex(columnIndex, columnList.size());
    V oldValue = array[rowIndex][columnIndex];
    array[rowIndex][columnIndex] = value;
    return oldValue;
  }
  
  @GwtIncompatible("reflection")
  public V[][] toArray(Class<V> valueClass)
  {
    V[][] copy = (Object[][])Array.newInstance(valueClass, new int[] { rowList.size(), columnList.size() });
    for (int i = 0; i < rowList.size(); i++) {
      System.arraycopy(array[i], 0, copy[i], 0, array[i].length);
    }
    return copy;
  }
  
  @Deprecated
  public void clear()
  {
    throw new UnsupportedOperationException();
  }
  
  public void eraseAll()
  {
    for (V[] row : array) {
      Arrays.fill(row, null);
    }
  }
  
  public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return (containsRow(rowKey)) && (containsColumn(columnKey));
  }
  
  public boolean containsColumn(@Nullable Object columnKey)
  {
    return columnKeyToIndex.containsKey(columnKey);
  }
  
  public boolean containsRow(@Nullable Object rowKey)
  {
    return rowKeyToIndex.containsKey(rowKey);
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    for (V[] row : array) {
      for (V element : row) {
        if (Objects.equal(value, element)) {
          return true;
        }
      }
    }
    return false;
  }
  
  public V get(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    Integer rowIndex = (Integer)rowKeyToIndex.get(rowKey);
    Integer columnIndex = (Integer)columnKeyToIndex.get(columnKey);
    return (rowIndex == null) || (columnIndex == null) ? null : at(rowIndex.intValue(), columnIndex.intValue());
  }
  
  public boolean isEmpty()
  {
    return false;
  }
  
  public V put(R rowKey, C columnKey, @Nullable V value)
  {
    Preconditions.checkNotNull(rowKey);
    Preconditions.checkNotNull(columnKey);
    Integer rowIndex = (Integer)rowKeyToIndex.get(rowKey);
    Preconditions.checkArgument(rowIndex != null, "Row %s not in %s", new Object[] { rowKey, rowList });
    Integer columnIndex = (Integer)columnKeyToIndex.get(columnKey);
    Preconditions.checkArgument(columnIndex != null, "Column %s not in %s", new Object[] { columnKey, columnList });
    
    return (V)set(rowIndex.intValue(), columnIndex.intValue(), value);
  }
  
  public void putAll(Table<? extends R, ? extends C, ? extends V> table)
  {
    super.putAll(table);
  }
  
  @Deprecated
  public V remove(Object rowKey, Object columnKey)
  {
    throw new UnsupportedOperationException();
  }
  
  public V erase(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    Integer rowIndex = (Integer)rowKeyToIndex.get(rowKey);
    Integer columnIndex = (Integer)columnKeyToIndex.get(columnKey);
    if ((rowIndex == null) || (columnIndex == null)) {
      return null;
    }
    return (V)set(rowIndex.intValue(), columnIndex.intValue(), null);
  }
  
  public int size()
  {
    return rowList.size() * columnList.size();
  }
  
  public Set<Table.Cell<R, C, V>> cellSet()
  {
    return super.cellSet();
  }
  
  Iterator<Table.Cell<R, C, V>> cellIterator()
  {
    new AbstractIndexedListIterator(size())
    {
      protected Table.Cell<R, C, V> get(final int index)
      {
        new Tables.AbstractCell()
        {
          final int rowIndex = index / columnList.size();
          final int columnIndex = index % columnList.size();
          
          public R getRowKey()
          {
            return (R)rowList.get(rowIndex);
          }
          
          public C getColumnKey()
          {
            return (C)columnList.get(columnIndex);
          }
          
          public V getValue()
          {
            return (V)at(rowIndex, columnIndex);
          }
        };
      }
    };
  }
  
  public Map<R, V> column(C columnKey)
  {
    Preconditions.checkNotNull(columnKey);
    Integer columnIndex = (Integer)columnKeyToIndex.get(columnKey);
    return columnIndex == null ? ImmutableMap.of() : new Column(columnIndex.intValue());
  }
  
  private class Column
    extends ArrayTable.ArrayMap<R, V>
  {
    final int columnIndex;
    
    Column(int columnIndex)
    {
      super(null);
      this.columnIndex = columnIndex;
    }
    
    String getKeyRole()
    {
      return "Row";
    }
    
    V getValue(int index)
    {
      return (V)at(index, columnIndex);
    }
    
    V setValue(int index, V newValue)
    {
      return (V)set(index, columnIndex, newValue);
    }
  }
  
  public ImmutableSet<C> columnKeySet()
  {
    return columnKeyToIndex.keySet();
  }
  
  public Map<C, Map<R, V>> columnMap()
  {
    ArrayTable<R, C, V>.ColumnMap map = columnMap;
    return map == null ? (columnMap = new ColumnMap(null)) : map;
  }
  
  private class ColumnMap
    extends ArrayTable.ArrayMap<C, Map<R, V>>
  {
    private ColumnMap()
    {
      super(null);
    }
    
    String getKeyRole()
    {
      return "Column";
    }
    
    Map<R, V> getValue(int index)
    {
      return new ArrayTable.Column(ArrayTable.this, index);
    }
    
    Map<R, V> setValue(int index, Map<R, V> newValue)
    {
      throw new UnsupportedOperationException();
    }
    
    public Map<R, V> put(C key, Map<R, V> value)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public Map<C, V> row(R rowKey)
  {
    Preconditions.checkNotNull(rowKey);
    Integer rowIndex = (Integer)rowKeyToIndex.get(rowKey);
    return rowIndex == null ? ImmutableMap.of() : new Row(rowIndex.intValue());
  }
  
  private class Row
    extends ArrayTable.ArrayMap<C, V>
  {
    final int rowIndex;
    
    Row(int rowIndex)
    {
      super(null);
      this.rowIndex = rowIndex;
    }
    
    String getKeyRole()
    {
      return "Column";
    }
    
    V getValue(int index)
    {
      return (V)at(rowIndex, index);
    }
    
    V setValue(int index, V newValue)
    {
      return (V)set(rowIndex, index, newValue);
    }
  }
  
  public ImmutableSet<R> rowKeySet()
  {
    return rowKeyToIndex.keySet();
  }
  
  public Map<R, Map<C, V>> rowMap()
  {
    ArrayTable<R, C, V>.RowMap map = rowMap;
    return map == null ? (rowMap = new RowMap(null)) : map;
  }
  
  private class RowMap
    extends ArrayTable.ArrayMap<R, Map<C, V>>
  {
    private RowMap()
    {
      super(null);
    }
    
    String getKeyRole()
    {
      return "Row";
    }
    
    Map<C, V> getValue(int index)
    {
      return new ArrayTable.Row(ArrayTable.this, index);
    }
    
    Map<C, V> setValue(int index, Map<C, V> newValue)
    {
      throw new UnsupportedOperationException();
    }
    
    public Map<C, V> put(R key, Map<C, V> value)
    {
      throw new UnsupportedOperationException();
    }
  }
  
  public Collection<V> values()
  {
    return super.values();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */