package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Map;

class ArrayTable$RowMap
  extends ArrayTable.ArrayMap<R, Map<C, V>>
{
  private ArrayTable$RowMap(ArrayTable paramArrayTable)
  {
    super(ArrayTable.access$200(paramArrayTable), null);
  }
  
  String getKeyRole()
  {
    return "Row";
  }
  
  Map<C, V> getValue(int index)
  {
    return new ArrayTable.Row(this$0, index);
  }
  
  Map<C, V> setValue(int index, Map<C, V> newValue)
  {
    throw new UnsupportedOperationException();
  }
  
  public Map<C, V> put(R key, Map<C, V> value)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable.RowMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */