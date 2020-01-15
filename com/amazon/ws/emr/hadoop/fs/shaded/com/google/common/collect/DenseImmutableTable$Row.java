package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class DenseImmutableTable$Row
  extends DenseImmutableTable.ImmutableArrayMap<C, V>
{
  private final int rowIndex;
  
  DenseImmutableTable$Row(DenseImmutableTable paramDenseImmutableTable, int rowIndex)
  {
    super(DenseImmutableTable.access$200(paramDenseImmutableTable)[rowIndex]);
    this.rowIndex = rowIndex;
  }
  
  ImmutableMap<C, Integer> keyToIndex()
  {
    return DenseImmutableTable.access$300(this$0);
  }
  
  V getValue(int keyIndex)
  {
    return (V)DenseImmutableTable.access$400(this$0)[rowIndex][keyIndex];
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DenseImmutableTable.Row
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */