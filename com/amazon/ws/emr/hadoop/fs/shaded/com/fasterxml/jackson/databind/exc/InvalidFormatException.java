package com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonLocation;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.JsonMappingException;

public class InvalidFormatException
  extends JsonMappingException
{
  private static final long serialVersionUID = 1L;
  protected final Object _value;
  protected final Class<?> _targetType;
  
  public InvalidFormatException(String msg, Object value, Class<?> targetType)
  {
    super(msg);
    _value = value;
    _targetType = targetType;
  }
  
  public InvalidFormatException(String msg, JsonLocation loc, Object value, Class<?> targetType)
  {
    super(msg, loc);
    _value = value;
    _targetType = targetType;
  }
  
  public static InvalidFormatException from(JsonParser jp, String msg, Object value, Class<?> targetType)
  {
    return new InvalidFormatException(msg, jp.getTokenLocation(), value, targetType);
  }
  
  public Object getValue()
  {
    return _value;
  }
  
  public Class<?> getTargetType()
  {
    return _targetType;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.databind.exc.InvalidFormatException
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */