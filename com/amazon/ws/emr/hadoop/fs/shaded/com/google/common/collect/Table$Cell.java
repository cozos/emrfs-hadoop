package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import javax.annotation.Nullable;

public abstract interface Table$Cell<R, C, V>
{
  public abstract R getRowKey();
  
  public abstract C getColumnKey();
  
  public abstract V getValue();
  
  public abstract boolean equals(@Nullable Object paramObject);
  
  public abstract int hashCode();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Table.Cell
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */