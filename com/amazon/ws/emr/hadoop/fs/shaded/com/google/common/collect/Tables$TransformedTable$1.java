package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Function;

class Tables$TransformedTable$1
  implements Function<Table.Cell<R, C, V1>, Table.Cell<R, C, V2>>
{
  Tables$TransformedTable$1(Tables.TransformedTable paramTransformedTable) {}
  
  public Table.Cell<R, C, V2> apply(Table.Cell<R, C, V1> cell)
  {
    return Tables.immutableCell(cell.getRowKey(), cell.getColumnKey(), this$0.function.apply(cell.getValue()));
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.Tables.TransformedTable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */