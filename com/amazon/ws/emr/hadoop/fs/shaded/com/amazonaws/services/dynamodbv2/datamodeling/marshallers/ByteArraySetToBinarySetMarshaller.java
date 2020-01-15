package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.ArgumentMarshaller.BinarySetAttributeMarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AttributeValue;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ByteArraySetToBinarySetMarshaller
  implements ArgumentMarshaller.BinarySetAttributeMarshaller
{
  private static final ByteArraySetToBinarySetMarshaller INSTANCE = new ByteArraySetToBinarySetMarshaller();
  
  public static ByteArraySetToBinarySetMarshaller instance()
  {
    return INSTANCE;
  }
  
  public AttributeValue marshall(Object obj)
  {
    Set<byte[]> buffers = (Set)obj;
    List<ByteBuffer> attributes = new ArrayList(buffers.size());
    for (byte[] b : buffers) {
      attributes.add(ByteBuffer.wrap(b));
    }
    return new AttributeValue().withBS(attributes);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.marshallers.ByteArraySetToBinarySetMarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */