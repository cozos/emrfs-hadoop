package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBMappingException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.lang.reflect.Method;

public class BooleanUnmarshaller
  implements ArgumentUnmarshaller
{
  private static final BooleanUnmarshaller INSTANCE = new BooleanUnmarshaller();
  
  public static BooleanUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public void typeCheck(AttributeValue value, Method setter)
  {
    if ((value.getN() == null) && (value.getBOOL() == null)) {
      throw new DynamoDBMappingException("Expected either N or BOOL in value " + value + " when invoking " + setter);
    }
  }
  
  public Object unmarshall(AttributeValue value)
  {
    if (value.getBOOL() != null) {
      return value.getBOOL();
    }
    if ("1".equals(value.getN())) {
      return Boolean.TRUE;
    }
    if ("0".equals(value.getN())) {
      return Boolean.FALSE;
    }
    throw new IllegalArgumentException("Expected '1', '0', or BOOL value for boolean value, was " + value);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.BooleanUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */