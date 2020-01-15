package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat;

import java.io.Serializable;
import java.util.Comparator;

class Frequency$NaturalComparator<T extends Comparable<T>>
  implements Comparator<Comparable<T>>, Serializable
{
  private static final long serialVersionUID = -3852193713161395148L;
  
  public int compare(Comparable<T> o1, Comparable<T> o2)
  {
    return o1.compareTo(o2);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.stat.Frequency.NaturalComparator
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */