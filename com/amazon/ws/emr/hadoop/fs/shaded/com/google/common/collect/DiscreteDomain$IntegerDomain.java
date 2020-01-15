package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

final class DiscreteDomain$IntegerDomain
  extends DiscreteDomain<Integer>
  implements Serializable
{
  private static final IntegerDomain INSTANCE = new IntegerDomain();
  private static final long serialVersionUID = 0L;
  
  public Integer next(Integer value)
  {
    int i = value.intValue();
    return i == Integer.MAX_VALUE ? null : Integer.valueOf(i + 1);
  }
  
  public Integer previous(Integer value)
  {
    int i = value.intValue();
    return i == Integer.MIN_VALUE ? null : Integer.valueOf(i - 1);
  }
  
  public long distance(Integer start, Integer end)
  {
    return end.intValue() - start.intValue();
  }
  
  public Integer minValue()
  {
    return Integer.valueOf(Integer.MIN_VALUE);
  }
  
  public Integer maxValue()
  {
    return Integer.valueOf(Integer.MAX_VALUE);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public String toString()
  {
    return "DiscreteDomain.integers()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DiscreteDomain.IntegerDomain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */