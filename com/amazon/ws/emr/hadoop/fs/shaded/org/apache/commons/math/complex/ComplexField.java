package com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.complex;

import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.Field;
import java.io.Serializable;

public class ComplexField
  implements Field<Complex>, Serializable
{
  private static final long serialVersionUID = -6130362688700788798L;
  
  public static ComplexField getInstance()
  {
    return LazyHolder.INSTANCE;
  }
  
  public Complex getOne()
  {
    return Complex.ONE;
  }
  
  public Complex getZero()
  {
    return Complex.ZERO;
  }
  
  private static class LazyHolder
  {
    private static final ComplexField INSTANCE = new ComplexField(null);
  }
  
  private Object readResolve()
  {
    return LazyHolder.INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.math.complex.ComplexField
 * Java Class Version: 5 (49.0)
 * JD-Core Version:    0.7.1
 */