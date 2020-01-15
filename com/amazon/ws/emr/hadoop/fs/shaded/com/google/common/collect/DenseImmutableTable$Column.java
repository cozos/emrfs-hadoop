package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

final class DenseImmutableTable$Column
  extends DenseImmutableTable.ImmutableArrayMap<R, V>
{
  private final int columnIndex;
  
  DenseImmutableTable$Column(DenseImmutableTable paramDenseImmutableTable, int columnIndex)
  {
    super(DenseImmutableTable.access$500(paramDenseImmutableTable)[columnIndex]);
    this.columnIndex = columnIndex;
  }
  
  ImmutableMap<R, Integer> keyToIndex()
  {
    return DenseImmutableTable.access$600(this$0);
  }
  
  V getValue(int keyIndex)
  {
    return (V)DenseImmutableTable.access$400(this$0)[keyIndex][columnIndex];
  }
  
  boolean isPartialView()
  {
    return true;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DenseImmutableTable.Column
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */