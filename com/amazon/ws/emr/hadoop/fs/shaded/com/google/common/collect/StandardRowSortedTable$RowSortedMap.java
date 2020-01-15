package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import java.util.Comparator;
import java.util.Map;
import java.util.SortedMap;
import java.util.SortedSet;

class StandardRowSortedTable$RowSortedMap
  extends StandardTable<R, C, V>.RowMap
  implements SortedMap<R, Map<C, V>>
{
  private StandardRowSortedTable$RowSortedMap(StandardRowSortedTable paramStandardRowSortedTable)
  {
    super(paramStandardRowSortedTable);
  }
  
  public SortedSet<R> keySet()
  {
    return (SortedSet)super.keySet();
  }
  
  SortedSet<R> createKeySet()
  {
    return new Maps.SortedKeySet(this);
  }
  
  public Comparator<? super R> comparator()
  {
    return StandardRowSortedTable.access$100(this$0).comparator();
  }
  
  public R firstKey()
  {
    return (R)StandardRowSortedTable.access$100(this$0).firstKey();
  }
  
  public R lastKey()
  {
    return (R)StandardRowSortedTable.access$100(this$0).lastKey();
  }
  
  public SortedMap<R, Map<C, V>> headMap(R toKey)
  {
    Preconditions.checkNotNull(toKey);
    return new StandardRowSortedTable(StandardRowSortedTable.access$100(this$0).headMap(toKey), this$0.factory).rowMap();
  }
  
  public SortedMap<R, Map<C, V>> subMap(R fromKey, R toKey)
  {
    Preconditions.checkNotNull(fromKey);
    Preconditions.checkNotNull(toKey);
    return new StandardRowSortedTable(StandardRowSortedTable.access$100(this$0).subMap(fromKey, toKey), this$0.factory).rowMap();
  }
  
  public SortedMap<R, Map<C, V>> tailMap(R fromKey)
  {
    Preconditions.checkNotNull(fromKey);
    return new StandardRowSortedTable(StandardRowSortedTable.access$100(this$0).tailMap(fromKey), this$0.factory).rowMap();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.StandardRowSortedTable.RowSortedMap
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */