package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.Field;
import java.io.Serializable;

public class BigFractionField
  implements Field<BigFraction>, Serializable
{
  private static final long serialVersionUID = -1699294557189741703L;
  
  public static BigFractionField getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  public BigFraction getOne()
  {
    return BigFraction.ONE;
  }
  
  public BigFraction getZero()
  {
    return BigFraction.ZERO;
  }
  
  private static class LazyHolder
  {
    private static final BigFractionField INSTANCE = new BigFractionField(null);
  }
  
  private Object readResolve()
  {
    return LazyHolder.INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.BigFractionField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */