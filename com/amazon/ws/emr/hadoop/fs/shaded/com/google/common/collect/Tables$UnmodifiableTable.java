package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Collection;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import javax.annotation.Nullable;

class Tables$UnmodifiableTable<R, C, V>
  extends ForwardingTable<R, C, V>
  implements Serializable
{
  final Table<? extends R, ? extends C, ? extends V> delegate;
  private static final long serialVersionUID = 0L;
  
  Tables$UnmodifiableTable(Table<? extends R, ? extends C, ? extends V> delegate)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables.UnmodifiableTable
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */