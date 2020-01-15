package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.util.UUID;

public class UUIDUnmarshaller
  extends SUnmarshaller
{
  private static final UUIDUnmarshaller INSTANCE = new UUIDUnmarshaller();
  
  public static UUIDUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public UUID unmarshall(AttributeValue value)
  {
    return UUID.fromString(value.getS());
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.UUIDUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */