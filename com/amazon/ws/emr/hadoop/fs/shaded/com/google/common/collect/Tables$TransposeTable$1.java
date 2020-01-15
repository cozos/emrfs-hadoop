package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

final class Tables$TransposeTable$1
  implements Function<Table.Cell<?, ?, ?>, Table.Cell<?, ?, ?>>
{
  public Table.Cell<?, ?, ?> apply(Table.Cell<?, ?, ?> cell)
  {
    return Tables.immutableCell(cell.getColumnKey(), cell.getRowKey(), cell.getValue());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables.TransposeTable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */