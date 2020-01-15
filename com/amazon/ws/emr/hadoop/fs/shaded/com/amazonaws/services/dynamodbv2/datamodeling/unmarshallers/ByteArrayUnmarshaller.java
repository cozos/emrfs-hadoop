package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;

public class ByteArrayUnmarshaller
  extends BUnmarshaller
{
  private static final ByteArrayUnmarshaller INSTANCE = new ByteArrayUnmarshaller();
  
  public static ByteArrayUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    ByteBuffer buffer = value.getB();
    if (buffer.hasArray()) {
      return buffer.array();
    }
    byte[] array = new byte[buffer.remaining()];
    buffer.get(array);
    return array;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteArrayUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */