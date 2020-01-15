package com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Converter;
import java.io.Serializable;

final class Longs$LongConverter
  extends Converter<String, Long>
  implements Serializable
{
  static final LongConverter INSTANCE = new LongConverter();
  private static final long serialVersionUID = 1L;
  
  protected Long doForward(String value)
  {
    return Long.decode(value);
  }
  
  protected String doBackward(Long value)
  {
    return value.toString();
  }
  
  public String toString()
  {
    return "Longs.stringConverter()";
  }
  
  private Object readResolve()
  {
    return INSTANCE;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.primitives.Longs.LongConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */