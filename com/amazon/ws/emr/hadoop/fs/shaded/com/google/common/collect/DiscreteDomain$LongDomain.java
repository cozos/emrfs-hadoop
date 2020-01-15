package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;

final class DiscreteDomain$LongDomain
  extends DiscreteDomain<Long>
  implements Serializable
{
  private static final LongDomain INSTANCE = new LongDomain();
  private static final long serialVersionUID = 0L;
  
  public Long next(Long value)
  {
    long l = value.longValue();
    return l == Long.MAX_VALUE ? null : Long.valueOf(l + 1L);
  }
  
  public Long previous(Long value)
  {
    long l = value.longValue();
    return l == Long.MIN_VALUE ? null : Long.valueOf(l - 1L);
  }
  
  public long distance(Long start, Long end)
  {
    long result = end.longValue() - start.longValue();
    if ((end.longValue() > start.longValue()) && (result < 0L)) {
      return Long.MAX_VALUE;
    }
    if ((end.longValue() < start.longValue()) && (result > 0L)) {
      return Long.MIN_VALUE;
    }
    return result;
  }
  
  public Long minValue()
  {
    return Long.valueOf(Long.MIN_VALUE);
  }
  
  public Long maxValue()
  {
    return Long.valueOf(Long.MAX_VALUE);
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public String toString()
  {
    return "DiscreteDomain.longs()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DiscreteDomain.LongDomain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */