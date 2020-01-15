package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map;

class ArrayTable$ColumnMap
  extends ArrayTable.ArrayMap<C, Map<R, V>>
{
  private ArrayTable$ColumnMap(ArrayTable paramArrayTable)
  {
    super(ArrayTable.access$500(paramArrayTable), null);
  }
  
  String getKeyRole()
  {
    return "Column";
  }
  
  Map<R, V> getValue(int index)
  {
    return new ArrayTable.Column(this$0, index);
  }
  
  Map<R, V> setValue(int index, Map<R, V> newValue)
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<R, V> put(C key, Map<R, V> value)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable.ColumnMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */