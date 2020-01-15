package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect;

import java.io.Serializable;
import java.math.BigInteger;

final class DiscreteDomain$BigIntegerDomain
  extends DiscreteDomain<BigInteger>
  implements Serializable
{
  private static final BigIntegerDomain INSTANCE = new BigIntegerDomain();
  private static final BigInteger MIN_LONG = BigInteger.valueOf(Long.MIN_VALUE);
  private static final BigInteger MAX_LONG = BigInteger.valueOf(Long.MAX_VALUE);
  private static final long serialVersionUID = 0L;
  
  public BigInteger next(BigInteger value)
  {
    return value.add(BigInteger.ONE);
  }
  
  public BigInteger previous(BigInteger value)
  {
    return value.subtract(BigInteger.ONE);
  }
  
  public long distance(BigInteger start, BigInteger end)
  {
    return end.subtract(start).max(MIN_LONG).min(MAX_LONG).longValue();
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
  
  public String toString()
  {
    return "DiscreteDomain.bigIntegers()";
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.DiscreteDomain.BigIntegerDomain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */