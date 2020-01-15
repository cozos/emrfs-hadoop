package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map;

final class DenseImmutableTable$RowMap
  extends DenseImmutableTable.ImmutableArrayMap<R, Map<C, V>>
{
  private DenseImmutableTable$RowMap(DenseImmutableTable paramDenseImmutableTable)
  {
    super(DenseImmutableTable.access$200(paramDenseImmutableTable).length);
  }
  
  ImmutableMap<R, Integer> keyToIndex()
  {
    return DenseImmutableTable.access$600(this$0);
  }
  
  Map<C, V> getValue(int keyIndex)
  {
    return new DenseImmutableTable.Row(this$0, keyIndex);
  }
  
  boolean isPartialView()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DenseImmutableTable.RowMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */