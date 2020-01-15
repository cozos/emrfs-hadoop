package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map;

final class DenseImmutableTable$ColumnMap
  extends DenseImmutableTable.ImmutableArrayMap<C, Map<R, V>>
{
  private DenseImmutableTable$ColumnMap(DenseImmutableTable paramDenseImmutableTable)
  {
    super(DenseImmutableTable.access$500(paramDenseImmutableTable).length);
  }
  
  ImmutableMap<C, Integer> keyToIndex()
  {
    return DenseImmutableTable.access$300(this$0);
  }
  
  Map<R, V> getValue(int keyIndex)
  {
    return new DenseImmutableTable.Column(this$0, keyIndex);
  }
  
  boolean isPartialView()
  {
    return false;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DenseImmutableTable.ColumnMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */