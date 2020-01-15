package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.BinaryAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;

public class ByteBufferToBinaryMarshaller
  implements ArgumentMarshaller.BinaryAttributeMarshaller
{
  private static final ByteBufferToBinaryMarshaller INSTANCE = new ByteBufferToBinaryMarshaller();
  
  public static ByteBufferToBinaryMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    return new AttributeValue().withB((ByteBuffer)obj);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ByteBufferToBinaryMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */