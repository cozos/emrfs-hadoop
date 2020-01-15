package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.util.Comparator;
import java.util.Iterator;

class TreeBasedTable$2
  extends AbstractIterator<C>
{
  C lastValue;
  
  TreeBasedTable$2(TreeBasedTable paramTreeBasedTable, Iterator paramIterator, Comparator paramComparator) {}
  
  protected C computeNext()
  {
    while (val$merged.hasNext())
    {
      C next = val$merged.next();
      boolean duplicate = (lastValue != null) && (val$comparator.compare(next, lastValue) == 0);
      if (!duplicate)
      {
        lastValue = next;
        return (C)lastValue;
      }
    }
    lastValue = null;
    return (C)endOfData();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.TreeBasedTable.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */