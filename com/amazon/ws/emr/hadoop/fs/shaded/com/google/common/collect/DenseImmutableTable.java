package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class DenseImmutableTable<R, C, V>
  extends RegularImmutableTable<R, C, V>
{
  private final ImmutableMap<R, Integer> rowKeyToIndex;
  private final ImmutableMap<C, Integer> columnKeyToIndex;
  private final ImmutableMap<R, Map<C, V>> rowMap;
  private final ImmutableMap<C, Map<R, V>> columnMap;
  private final int[] rowCounts;
  private final int[] columnCounts;
  private final V[][] values;
  private final int[] iterationOrderRow;
  private final int[] iterationOrderColumn;
  
  private static <E> ImmutableMap<E, Integer> makeIndex(ImmutableSet<E> set)
  {
    ImmutableMap.Builder<E, Integer> indexBuilder = ImmutableMap.builder();
    int i = 0;
    for (E key : set)
    {
      indexBuilder.put(key, Integer.valueOf(i));
      i++;
    }
    return indexBuilder.build();
  }
  
  DenseImmutableTable(ImmutableList<Table.Cell<R, C, V>> cellList, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace)
  {
    V[][] array = (Object[][])new Object[rowSpace.size()][columnSpace.size()];
    values = array;
    rowKeyToIndex = makeIndex(rowSpace);
    columnKeyToIndex = makeIndex(columnSpace);
    rowCounts = new int[rowKeyToIndex.size()];
    columnCounts = new int[columnKeyToIndex.size()];
    int[] iterationOrderRow = new int[cellList.size()];
    int[] iterationOrderColumn = new int[cellList.size()];
    for (int i = 0; i < cellList.size(); i++)
    {
      Table.Cell<R, C, V> cell = (Table.Cell)cellList.get(i);
      R rowKey = cell.getRowKey();
      C columnKey = cell.getColumnKey();
      int rowIndex = ((Integer)rowKeyToIndex.get(rowKey)).intValue();
      int columnIndex = ((Integer)columnKeyToIndex.get(columnKey)).intValue();
      V existingValue = values[rowIndex][columnIndex];
      Preconditions.checkArgument(existingValue == null, "duplicate key: (%s, %s)", new Object[] { rowKey, columnKey });
      values[rowIndex][columnIndex] = cell.getValue();
      rowCounts[rowIndex] += 1;
      columnCounts[columnIndex] += 1;
      iterationOrderRow[i] = rowIndex;
      iterationOrderColumn[i] = columnIndex;
    }
    this.iterationOrderRow = iterationOrderRow;
    this.iterationOrderColumn = iterationOrderColumn;
    rowMap = new RowMap(null);
    columnMap = new ColumnMap(null);
  }
  
  private static abstract class ImmutableArrayMap<K, V>
    extends ImmutableMap<K, V>
  {
    private final int size;
    
    ImmutableArrayMap(int size)
    {
      this.size = size;
    }
    
    abstract ImmutableMap<K, Integer> keyToIndex();
    
    private boolean isFull()
    {
      return size == keyToIndex().size();
    }
    
    K getKey(int index)
    {
      return (K)keyToIndex().keySet().asList().get(index);
    }
    
    @Nullable
    abstract V getValue(int paramInt);
    
    ImmutableSet<K> createKeySet()
    {
      return isFull() ? keyToIndex().keySet() : super.createKeySet();
    }
    
    public int size()
    {
      return size;
    }
    
    public V get(@Nullable Object key)
    {
      Integer keyIndex = (Integer)keyToIndex().get(key);
      return keyIndex == null ? null : getValue(keyIndex.intValue());
    }
    
    ImmutableSet<Map.Entry<K, V>> createEntrySet()
    {
      new ImmutableMapEntrySet()
      {
        ImmutableMap<K, V> map()
        {
          return DenseImmutableTable.ImmutableArrayMap.this;
        }
        
        public UnmodifiableIterator<Map.Entry<K, V>> iterator()
        {
          new AbstractIterator()
          {
            private int index = -1;
            private final int maxIndex = keyToIndex().size();
            
            protected Map.Entry<K, V> computeNext()
            {
              for (index += 1; index < maxIndex; index += 1)
              {
                V value = getValue(index);
                if (value != null) {
                  return Maps.immutableEntry(getKey(index), value);
                }
              }
              return (Map.Entry)endOfData();
            }
          };
        }
      };
    }
  }
  
  private final class Row
    extends DenseImmutableTable.ImmutableArrayMap<C, V>
  {
    private final int rowIndex;
    
    Row(int rowIndex)
    {
      super();
      this.rowIndex = rowIndex;
    }
    
    ImmutableMap<C, Integer> keyToIndex()
    {
      return columnKeyToIndex;
    }
    
    V getValue(int keyIndex)
    {
      return (V)values[rowIndex][keyIndex];
    }
    
    boolean isPartialView()
    {
      return true;
    }
  }
  
  private final class Column
    extends DenseImmutableTable.ImmutableArrayMap<R, V>
  {
    private final int columnIndex;
    
    Column(int columnIndex)
    {
      super();
      this.columnIndex = columnIndex;
    }
    
    ImmutableMap<R, Integer> keyToIndex()
    {
      return rowKeyToIndex;
    }
    
    V getValue(int keyIndex)
    {
      return (V)values[keyIndex][columnIndex];
    }
    
    boolean isPartialView()
    {
      return true;
    }
  }
  
  private final class RowMap
    extends DenseImmutableTable.ImmutableArrayMap<R, Map<C, V>>
  {
    private RowMap()
    {
      super();
    }
    
    ImmutableMap<R, Integer> keyToIndex()
    {
      return rowKeyToIndex;
    }
    
    Map<C, V> getValue(int keyIndex)
    {
      return new DenseImmutableTable.Row(DenseImmutableTable.this, keyIndex);
    }
    
    boolean isPartialView()
    {
      return false;
    }
  }
  
  private final class ColumnMap
    extends DenseImmutableTable.ImmutableArrayMap<C, Map<R, V>>
  {
    private ColumnMap()
    {
      super();
    }
    
    ImmutableMap<C, Integer> keyToIndex()
    {
      return columnKeyToIndex;
    }
    
    Map<R, V> getValue(int keyIndex)
    {
      return new DenseImmutableTable.Column(DenseImmutableTable.this, keyIndex);
    }
    
    boolean isPartialView()
    {
      return false;
    }
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return columnMap;
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return rowMap;
  }
  
  public V get(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    Integer rowIndex = (Integer)rowKeyToIndex.get(rowKey);
    Integer columnIndex = (Integer)columnKeyToIndex.get(columnKey);
    return (rowIndex == null) || (columnIndex == null) ? null : values[rowIndex.intValue()][columnIndex.intValue()];
  }
  
  public int size()
  {
    return iterationOrderRow.length;
  }
  
  Table.Cell<R, C, V> getCell(int index)
  {
    int rowIndex = iterationOrderRow[index];
    int columnIndex = iterationOrderColumn[index];
    R rowKey = rowKeySet().asList().get(rowIndex);
    C columnKey = columnKeySet().asList().get(columnIndex);
    V value = values[rowIndex][columnIndex];
    return cellOf(rowKey, columnKey, value);
  }
  
  V getValue(int index)
  {
    return (V)values[iterationOrderRow[index]][iterationOrderColumn[index]];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DenseImmutableTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */