package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3;

import java.util.Comparator;

 enum Range$ComparableComparator
  implements Comparator
{
  INSTANCE;
  
  private Range$ComparableComparator() {}
  
  public int compare(Object obj1, Object obj2)
  {
    return ((Comparable)obj1).compareTo(obj2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.lang3.Range.ComparableComparator
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */