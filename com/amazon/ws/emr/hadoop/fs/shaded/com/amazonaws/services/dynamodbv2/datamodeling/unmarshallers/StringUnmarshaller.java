package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class StringUnmarshaller
  extends SUnmarshaller
{
  private static final StringUnmarshaller INSTANCE = new StringUnmarshaller();
  
  public static StringUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    return value.getS();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.StringUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */