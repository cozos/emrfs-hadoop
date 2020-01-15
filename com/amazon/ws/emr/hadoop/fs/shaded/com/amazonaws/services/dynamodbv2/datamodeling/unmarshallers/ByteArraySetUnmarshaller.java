package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;
import java.util.HashSet;
import java.util.Set;

public class ByteArraySetUnmarshaller
  extends BSUnmarshaller
{
  private static final ByteArraySetUnmarshaller INSTANCE = new ByteArraySetUnmarshaller();
  
  public static ByteArraySetUnmarshaller instance()
  {
    return INSTANCE;
  }
  
  public Object unmarshall(AttributeValue value)
  {
    Set<byte[]> result = new HashSet();
    for (ByteBuffer buffer : value.getBS()) {
      if (buffer.hasArray())
      {
        result.add(buffer.array());
      }
      else
      {
        byte[] array = new byte[buffer.remaining()];
        buffer.get(array);
        result.add(array);
      }
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.unmarshallers.ByteArraySetUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */