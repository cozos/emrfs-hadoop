package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

class ArrayTable$1
  extends AbstractIndexedListIterator<Table.Cell<R, C, V>>
{
  ArrayTable$1(ArrayTable paramArrayTable, int x0)
  {
    super(x0);
  }
  
  protected Table.Cell<R, C, V> get(final int index)
  {
    new Tables.AbstractCell()
    {
      final int rowIndex = index / ArrayTable.access$000(this$0).size();
      final int columnIndex = index % ArrayTable.access$000(this$0).size();
      
      public R getRowKey()
      {
        return (R)ArrayTable.access$100(this$0).get(rowIndex);
      }
      
      public C getColumnKey()
      {
        return (C)ArrayTable.access$000(this$0).get(columnIndex);
      }
      
      public V getValue()
      {
        return (V)this$0.at(rowIndex, columnIndex);
      }
    };
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ArrayTable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */