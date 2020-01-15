package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter;
import java.io.Serializable;

final class Ints$IntConverter
  extends Converter<String, Integer>
  implements Serializable
{
  static final IntConverter INSTANCE = new IntConverter();
  private static final long serialVersionUID = 1L;
  
  protected Integer doForward(String value)
  {
    return Integer.decode(value);
  }
  
  protected String doBackward(Integer value)
  {
    return value.toString();
  }
  
  public String toString()
  {
    return "Ints.stringConverter()";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Ints.IntConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */