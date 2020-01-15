package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import javax.annotation.concurrent.Immutable;

@GwtCompatible
@Immutable
final class SparseImmutableTable<R, C, V>
  extends RegularImmutableTable<R, C, V>
{
  private final ImmutableMap<R, Map<C, V>> rowMap;
  private final ImmutableMap<C, Map<R, V>> columnMap;
  private final int[] iterationOrderRow;
  private final int[] iterationOrderColumn;
  
  SparseImmutableTable(ImmutableList<Table.Cell<R, C, V>> cellList, ImmutableSet<R> rowSpace, ImmutableSet<C> columnSpace)
  {
    Map<R, Integer> rowIndex = Maps.newHashMap();
    Map<R, Map<C, V>> rows = Maps.newLinkedHashMap();
    for (R row : rowSpace)
    {
      rowIndex.put(row, Integer.valueOf(rows.size()));
      rows.put(row, new LinkedHashMap());
    }
    Map<C, Map<R, V>> columns = Maps.newLinkedHashMap();
    for (C col : columnSpace) {
      columns.put(col, new LinkedHashMap());
    }
    int[] iterationOrderRow = new int[cellList.size()];
    int[] iterationOrderColumn = new int[cellList.size()];
    for (int i = 0; i < cellList.size(); i++)
    {
      Table.Cell<R, C, V> cell = (Table.Cell)cellList.get(i);
      R rowKey = cell.getRowKey();
      C columnKey = cell.getColumnKey();
      V value = cell.getValue();
      
      iterationOrderRow[i] = ((Integer)rowIndex.get(rowKey)).intValue();
      Map<C, V> thisRow = (Map)rows.get(rowKey);
      iterationOrderColumn[i] = thisRow.size();
      V oldValue = thisRow.put(columnKey, value);
      if (oldValue != null)
      {
        String str1 = String.valueOf(String.valueOf(rowKey));String str2 = String.valueOf(String.valueOf(columnKey));String str3 = String.valueOf(String.valueOf(value));String str4 = String.valueOf(String.valueOf(oldValue));throw new IllegalArgumentException(37 + str1.length() + str2.length() + str3.length() + str4.length() + "Duplicate value for row=" + str1 + ", column=" + str2 + ": " + str3 + ", " + str4);
      }
      ((Map)columns.get(columnKey)).put(rowKey, value);
    }
    this.iterationOrderRow = iterationOrderRow;
    this.iterationOrderColumn = iterationOrderColumn;
    ImmutableMap.Builder<R, Map<C, V>> rowBuilder = ImmutableMap.builder();
    for (Map.Entry<R, Map<C, V>> row : rows.entrySet()) {
      rowBuilder.put(row.getKey(), ImmutableMap.copyOf((Map)row.getValue()));
    }
    rowMap = rowBuilder.build();
    
    ImmutableMap.Builder<C, Map<R, V>> columnBuilder = ImmutableMap.builder();
    for (Map.Entry<C, Map<R, V>> col : columns.entrySet()) {
      columnBuilder.put(col.getKey(), ImmutableMap.copyOf((Map)col.getValue()));
    }
    columnMap = columnBuilder.build();
  }
  
  public ImmutableMap<C, Map<R, V>> columnMap()
  {
    return columnMap;
  }
  
  public ImmutableMap<R, Map<C, V>> rowMap()
  {
    return rowMap;
  }
  
  public int size()
  {
    return iterationOrderRow.length;
  }
  
  Table.Cell<R, C, V> getCell(int index)
  {
    int rowIndex = iterationOrderRow[index];
    Map.Entry<R, Map<C, V>> rowEntry = (Map.Entry)rowMap.entrySet().asList().get(rowIndex);
    ImmutableMap<C, V> row = (ImmutableMap)rowEntry.getValue();
    int columnIndex = iterationOrderColumn[index];
    Map.Entry<C, V> colEntry = (Map.Entry)row.entrySet().asList().get(columnIndex);
    return cellOf(rowEntry.getKey(), colEntry.getKey(), colEntry.getValue());
  }
  
  V getValue(int index)
  {
    int rowIndex = iterationOrderRow[index];
    ImmutableMap<C, V> row = (ImmutableMap)rowMap.values().asList().get(rowIndex);
    int columnIndex = iterationOrderColumn[index];
    return (V)row.values().asList().get(columnIndex);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.SparseImmutableTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */