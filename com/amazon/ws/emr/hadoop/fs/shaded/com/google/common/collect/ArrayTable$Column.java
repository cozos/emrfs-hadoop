package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class ArrayTable$Column
  extends ArrayTable.ArrayMap<R, V>
{
  final int columnIndex;
  
  ArrayTable$Column(ArrayTable paramArrayTable, int columnIndex)
  {
    super(ArrayTable.access$200(paramArrayTable), null);
    this.columnIndex = columnIndex;
  }
  
  String getKeyRole()
  {
    return "Row";
  }
  
  V getValue(int index)
  {
    return (V)this$0.at(index, columnIndex);
  }
  
  V setValue(int index, V newValue)
  {
    return (V)this$0.set(index, columnIndex, newValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable.Column
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */