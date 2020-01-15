package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.BinarySetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ByteBufferSetToBinarySetMarshaller
  implements ArgumentMarshaller.BinarySetAttributeMarshaller
{
  private static final ByteBufferSetToBinarySetMarshaller INSTANCE = new ByteBufferSetToBinarySetMarshaller();
  
  public static ByteBufferSetToBinarySetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<ByteBuffer> buffers = (Set)obj;
    List<ByteBuffer> attributes = new ArrayList(buffers.size());
    for (ByteBuffer b : buffers) {
      attributes.add(b);
    }
    return new AttributeValue().withBS(attributes);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ByteBufferSetToBinarySetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */