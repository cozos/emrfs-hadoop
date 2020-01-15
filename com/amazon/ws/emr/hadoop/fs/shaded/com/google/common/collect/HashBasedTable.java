package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;

@GwtCompatible(serializable=true)
public class HashBasedTable<R, C, V>
  extends StandardTable<R, C, V>
{
  private static final long serialVersionUID = 0L;
  
  private static class Factory<C, V>
    implements Supplier<Map<C, V>>, Serializable
  {
    final int expectedSize;
    private static final long serialVersionUID = 0L;
    
    Factory(int expectedSize)
    {
      this.expectedSize = expectedSize;
    }
    
    public Map<C, V> get()
    {
      return Maps.newHashMapWithExpectedSize(expectedSize);
    }
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create()
  {
    return new HashBasedTable(new HashMap(), new Factory(0));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(int expectedRows, int expectedCellsPerRow)
  {
    CollectPreconditions.checkNonnegative(expectedCellsPerRow, "expectedCellsPerRow");
    Map<R, Map<C, V>> backingMap = Maps.newHashMapWithExpectedSize(expectedRows);
    
    return new HashBasedTable(backingMap, new Factory(expectedCellsPerRow));
  }
  
  public static <R, C, V> HashBasedTable<R, C, V> create(Table<? extends R, ? extends C, ? extends V> table)
  {
    HashBasedTable<R, C, V> result = create();
    result.putAll(table);
    return result;
  }
  
  HashBasedTable(Map<R, Map<C, V>> backingMap, Factory<C, V> factory)
  {
    super(backingMap, factory);
  }
  
  public boolean contains(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return super.contains(rowKey, columnKey);
  }
  
  public boolean containsColumn(@Nullable Object columnKey)
  {
    return super.containsColumn(columnKey);
  }
  
  public boolean containsRow(@Nullable Object rowKey)
  {
    return super.containsRow(rowKey);
  }
  
  public boolean containsValue(@Nullable Object value)
  {
    return super.containsValue(value);
  }
  
  public V get(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return (V)super.get(rowKey, columnKey);
  }
  
  public boolean equals(@Nullable Object obj)
  {
    return super.equals(obj);
  }
  
  public V remove(@Nullable Object rowKey, @Nullable Object columnKey)
  {
    return (V)super.remove(rowKey, columnKey);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.HashBasedTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */