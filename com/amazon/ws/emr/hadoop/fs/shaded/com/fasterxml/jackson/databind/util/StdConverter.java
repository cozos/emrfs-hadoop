package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JavaType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.type.TypeFactory;

public abstract class StdConverter<IN, OUT>
  implements Converter<IN, OUT>
{
  public abstract OUT convert(IN paramIN);
  
  public JavaType getInputType(TypeFactory typeFactory)
  {
    JavaType[] types = typeFactory.findTypeParameters(getClass(), Converter.class);
    if ((types == null) || (types.length < 2)) {
      throw new IllegalStateException("Can not find OUT type parameter for Converter of type " + getClass().getName());
    }
    return types[0];
  }
  
  public JavaType getOutputType(TypeFactory typeFactory)
  {
    JavaType[] types = typeFactory.findTypeParameters(getClass(), Converter.class);
    if ((types == null) || (types.length < 2)) {
      throw new IllegalStateException("Can not find OUT type parameter for Converter of type " + getClass().getName());
    }
    return types[1];
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.util.StdConverter
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */