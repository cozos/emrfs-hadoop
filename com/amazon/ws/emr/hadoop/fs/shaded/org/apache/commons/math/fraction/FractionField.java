package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.Field;
import java.io.Serializable;

public class FractionField
  implements Field<Fraction>, Serializable
{
  private static final long serialVersionUID = -1257768487499119313L;
  
  public static FractionField getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  public Fraction getOne()
  {
    return Fraction.ONE;
  }
  
  public Fraction getZero()
  {
    return Fraction.ZERO;
  }
  
  private static class LazyHolder
  {
    private static final FractionField INSTANCE = new FractionField(null);
  }
  
  private Object readResolve()
  {
    return LazyHolder.INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.fraction.FractionField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */