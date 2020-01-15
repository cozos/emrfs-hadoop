package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;

public class ByteUnmarshaller
  extends NUnmarshaller
{
  private static final ByteUnmarshaller INSTANCE = new ByteUnmarshaller();
  
  public static ByteUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    return Byte.valueOf(value.getN());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */