package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter;
import java.io.Serializable;

final class Doubles$DoubleConverter
  extends Converter<String, Double>
  implements Serializable
{
  static final DoubleConverter INSTANCE = new DoubleConverter();
  private static final long serialVersionUID = 1L;
  
  protected Double doForward(String value)
  {
    return Double.valueOf(value);
  }
  
  protected String doBackward(Double value)
  {
    return value.toString();
  }
  
  public String toString()
  {
    return "Doubles.stringConverter()";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Doubles.DoubleConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */