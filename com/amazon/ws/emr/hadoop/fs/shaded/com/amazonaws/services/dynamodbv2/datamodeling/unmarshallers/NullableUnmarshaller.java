package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;
import java.text.ParseException;

public class NullableUnmarshaller
  implements ArgumentUnmarshaller
{
  private final ArgumentUnmarshaller wrapped;
  
  public NullableUnmarshaller(ArgumentUnmarshaller wrapped)
  {
    if (wrapped == null) {
      throw new NullPointerException("wrapped");
    }
    this.wrapped = wrapped;
  }
  
  public void typeCheck(AttributeValue value, Method setter)
  {
    if (value.isNULL() == null) {
      wrapped.typeCheck(value, setter);
    }
  }
  
  public Object unmarshall(AttributeValue value)
    throws ParseException
  {
    if (value.isNULL() != null) {
      return null;
    }
    return wrapped.unmarshall(value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.NullableUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */