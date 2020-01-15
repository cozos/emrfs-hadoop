package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter;
import java.io.Serializable;

final class Shorts$ShortConverter
  extends Converter<String, Short>
  implements Serializable
{
  static final ShortConverter INSTANCE = new ShortConverter();
  private static final long serialVersionUID = 1L;
  
  protected Short doForward(String value)
  {
    return Short.decode(value);
  }
  
  protected String doBackward(Short value)
  {
    return value.toString();
  }
  
  public String toString()
  {
    return "Shorts.stringConverter()";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Shorts.ShortConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */