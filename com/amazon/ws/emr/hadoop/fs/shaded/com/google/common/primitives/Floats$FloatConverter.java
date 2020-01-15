package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter;
import java.io.Serializable;

final class Floats$FloatConverter
  extends Converter<String, Float>
  implements Serializable
{
  static final FloatConverter INSTANCE = new FloatConverter();
  private static final long serialVersionUID = 1L;
  
  protected Float doForward(String value)
  {
    return Float.valueOf(value);
  }
  
  protected String doBackward(Float value)
  {
    return value.toString();
  }
  
  public String toString()
  {
    return "Floats.stringConverter()";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Floats.FloatConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */