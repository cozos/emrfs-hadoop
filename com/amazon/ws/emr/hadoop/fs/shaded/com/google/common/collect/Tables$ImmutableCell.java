package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import javax.annotation.Nullable;

final class Tables$ImmutableCell<R, C, V>
  extends Tables.AbstractCell<R, C, V>
  implements Serializable
{
  private final R rowKey;
  private final C columnKey;
  private final V value;
  private static final long serialVersionUID = 0L;
  
  Tables$ImmutableCell(@Nullable R rowKey, @Nullable C columnKey, @Nullable V value)
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

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables.ImmutableCell
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */