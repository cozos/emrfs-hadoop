package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.Beta;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.annotations.GwtCompatible;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Objects;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Supplier;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;
import javax.annotation.Nullable;

@GwtCompatible
public final class Tables
{
  public static <R, C, V> Table.Cell<R, C, V> immutableCell(@Nullable R rowKey, @Nullable C columnKey, @Nullable V value)
  {
    return new ImmutableCell(rowKey, columnKey, value);
  }
  
  static final class ImmutableCell<R, C, V>
    extends Tables.AbstractCell<R, C, V>
    implements Serializable
  {
    private final R rowKey;
    private final C columnKey;
    private final V value;
    private static final long serialVersionUID = 0L;
    
    ImmutableCell(@Nullable R rowKey, @Nullable C columnKey, @Nullable V value)
    {
      this.rowKey = rowKey;
      this.columnKey = columnKey;
      this.value = value;
    }
    
    public R getRowKey()
    {
      return (R)rowKey;
    }
    
    public C getColumnKey()
    {
      return (C)columnKey;
    }
    
    public V getValue()
    {
      return (V)value;
    }
  }
  
  static abstract class AbstractCell<R, C, V>
    implements Table.Cell<R, C, V>
  {
    public boolean equals(Object obj)
    {
      if (obj == this) {
        return true;
      }
      if ((obj instanceof Table.Cell))
      {
        Table.Cell<?, ?, ?> other = (Table.Cell)obj;
        return (Objects.equal(getRowKey(), other.getRowKey())) && (Objects.equal(getColumnKey(), other.getColumnKey())) && (Objects.equal(getValue(), other.getValue()));
      }
      return false;
    }
    
    public int hashCode()
    {
      return Objects.hashCode(new Object[] { getRowKey(), getColumnKey(), getValue() });
    }
    
    public String toString()
    {
      String str1 = String.valueOf(String.valueOf(getRowKey()));String str2 = String.valueOf(String.valueOf(getColumnKey()));String str3 = String.valueOf(String.valueOf(getValue()));return 4 + str1.length() + str2.length() + str3.length() + "(" + str1 + "," + str2 + ")=" + str3;
    }
  }
  
  public static <R, C, V> Table<C, R, V> transpose(Table<R, C, V> table)
  {
    return (table instanceof TransposeTable) ? original : new TransposeTable(table);
  }
  
  private static class TransposeTable<C, R, V>
    extends AbstractTable<C, R, V>
  {
    final Table<R, C, V> original;
    
    TransposeTable(Table<R, C, V> original)
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
  
  @Beta
  public static <R, C, V> Table<R, C, V> newCustomTable(Map<R, Map<C, V>> backingMap, Supplier<? extends Map<C, V>> factory)
  {
    Preconditions.checkArgument(backingMap.isEmpty());
    Preconditions.checkNotNull(factory);
    
    return new StandardTable(backingMap, factory);
  }
  
  @Beta
  public static <R, C, V1, V2> Table<R, C, V2> transformValues(Table<R, C, V1> fromTable, Function<? super V1, V2> function)
  {
    return new TransformedTable(fromTable, function);
  }
  
  private static class TransformedTable<R, C, V1, V2>
    extends AbstractTable<R, C, V2>
  {
    final Table<R, C, V1> fromTable;
    final Function<? super V1, V2> function;
    
    TransformedTable(Table<R, C, V1> fromTable, Function<? super V1, V2> function)
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
  
  public static <R, C, V> Table<R, C, V> unmodifiableTable(Table<? extends R, ? extends C, ? extends V> table)
  {
    return new UnmodifiableTable(table);
  }
  
  private static class UnmodifiableTable<R, C, V>
    extends ForwardingTable<R, C, V>
    implements Serializable
  {
    final Table<? extends R, ? extends C, ? extends V> delegate;
    private static final long serialVersionUID = 0L;
    
    UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> delegate)
    {
      this.delegate = ((Table)Preconditions.checkNotNull(delegate));
    }
    
    protected Table<R, C, V> delegate()
    {
      return delegate;
    }
    
    public Set<Table.Cell<R, C, V>> cellSet()
    {
      return Collections.unmodifiableSet(super.cellSet());
    }
    
    public void clear()
    {
      throw new UnsupportedOperationException();
    }
    
    public Map<R, V> column(@Nullable C columnKey)
    {
      return Collections.unmodifiableMap(super.column(columnKey));
    }
    
    public Set<C> columnKeySet()
    {
      return Collections.unmodifiableSet(super.columnKeySet());
    }
    
    public Map<C, Map<R, V>> columnMap()
    {
      Function<Map<R, V>, Map<R, V>> wrapper = Tables.access$000();
      return Collections.unmodifiableMap(Maps.transformValues(super.columnMap(), wrapper));
    }
    
    public V put(@Nullable R rowKey, @Nullable C columnKey, @Nullable V value)
    {
      throw new UnsupportedOperationException();
    }
    
    public void putAll(Table<? extends R, ? extends C, ? extends V> table)
    {
      throw new UnsupportedOperationException();
    }
    
    public V remove(@Nullable Object rowKey, @Nullable Object columnKey)
    {
      throw new UnsupportedOperationException();
    }
    
    public Map<C, V> row(@Nullable R rowKey)
    {
      return Collections.unmodifiableMap(super.row(rowKey));
    }
    
    public Set<R> rowKeySet()
    {
      return Collections.unmodifiableSet(super.rowKeySet());
    }
    
    public Map<R, Map<C, V>> rowMap()
    {
      Function<Map<C, V>, Map<C, V>> wrapper = Tables.access$000();
      return Collections.unmodifiableMap(Maps.transformValues(super.rowMap(), wrapper));
    }
    
    public Collection<V> values()
    {
      return Collections.unmodifiableCollection(super.values());
    }
  }
  
  @Beta
  public static <R, C, V> RowSortedTable<R, C, V> unmodifiableRowSortedTable(RowSortedTable<R, ? extends C, ? extends V> table)
  {
    return new UnmodifiableRowSortedMap(table);
  }
  
  static final class UnmodifiableRowSortedMap<R, C, V>
    extends Tables.UnmodifiableTable<R, C, V>
    implements RowSortedTable<R, C, V>
  {
    private static final long serialVersionUID = 0L;
    
    public UnmodifiableRowSortedMap(RowSortedTable<R, ? extends C, ? extends V> delegate)
    {
      super();
    }
    
    protected RowSortedTable<R, C, V> delegate()
    {
      return (RowSortedTable)super.delegate();
    }
    
    public SortedMap<R, Map<C, V>> rowMap()
    {
      Function<Map<C, V>, Map<C, V>> wrapper = Tables.access$000();
      return Collections.unmodifiableSortedMap(Maps.transformValues(delegate().rowMap(), wrapper));
    }
    
    public SortedSet<R> rowKeySet()
    {
      return Collections.unmodifiableSortedSet(delegate().rowKeySet());
    }
  }
  
  private static <K, V> Function<Map<K, V>, Map<K, V>> unmodifiableWrapper()
  {
    return UNMODIFIABLE_WRAPPER;
  }
  
  private static final Function<? extends Map<?, ?>, ? extends Map<?, ?>> UNMODIFIABLE_WRAPPER = new Function()
  {
    public Map<Object, Object> apply(Map<Object, Object> input)
    {
      return Collections.unmodifiableMap(input);
    }
  };
  
  static boolean equalsImpl(Table<?, ?, ?> table, @Nullable Object obj)
  {
    if (obj == table) {
      return true;
    }
    if ((obj instanceof Table))
    {
      Table<?, ?, ?> that = (Table)obj;
      return table.cellSet().equals(that.cellSet());
    }
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */