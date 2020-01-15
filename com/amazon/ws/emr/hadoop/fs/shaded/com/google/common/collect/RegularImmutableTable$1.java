package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;

final class RegularImmutableTable$1
  implements Comparator<Table.Cell<R, C, V>>
{
  RegularImmutableTable$1(Comparator paramComparator1, Comparator paramComparator2) {}
  
  public int compare(Table.Cell<R, C, V> cell1, Table.Cell<R, C, V> cell2)
  {
    int rowCompare = val$rowComparator == null ? 0 : val$rowComparator.compare(cell1.getRowKey(), cell2.getRowKey());
    if (rowCompare != 0) {
      return rowCompare;
    }
    return val$columnComparator == null ? 0 : val$columnComparator.compare(cell1.getColumnKey(), cell2.getColumnKey());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.RegularImmutableTable.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */