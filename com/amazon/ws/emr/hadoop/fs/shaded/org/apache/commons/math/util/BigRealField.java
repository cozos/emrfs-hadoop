package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.Field;
import java.io.Serializable;

public class BigRealField
  implements Field<BigReal>, Serializable
{
  private static final long serialVersionUID = 4756431066541037559L;
  
  public static BigRealField getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  public BigReal getOne()
  {
    return BigReal.ONE;
  }
  
  public BigReal getZero()
  {
    return BigReal.ZERO;
  }
  
  private static class LazyHolder
  {
    private static final BigRealField INSTANCE = new BigRealField(null);
  }
  
  private Object readResolve()
  {
    return LazyHolder.INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.util.BigRealField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */