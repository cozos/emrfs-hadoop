package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.HashSet;

public class ByteBufferSetUnmarshaller
  extends BSUnmarshaller
{
  private static final ByteBufferSetUnmarshaller INSTANCE = new ByteBufferSetUnmarshaller();
  
  public static ByteBufferSetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    return new HashSet(value.getBS());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteBufferSetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */