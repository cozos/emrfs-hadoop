package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class ArrayTable$Row
  extends ArrayTable.ArrayMap<C, V>
{
  final int rowIndex;
  
  ArrayTable$Row(ArrayTable paramArrayTable, int rowIndex)
  {
    super(ArrayTable.access$500(paramArrayTable), null);
    this.rowIndex = rowIndex;
  }
  
  String getKeyRole()
  {
    return "Column";
  }
  
  V getValue(int index)
  {
    return (V)this$0.at(rowIndex, index);
  }
  
  V setValue(int index, V newValue)
  {
    return (V)this$0.set(rowIndex, index, newValue);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable.Row
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */