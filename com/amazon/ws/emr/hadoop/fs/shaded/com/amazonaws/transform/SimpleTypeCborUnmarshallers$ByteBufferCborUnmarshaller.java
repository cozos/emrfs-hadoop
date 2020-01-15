package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.nio.ByteBuffer;

public class SimpleTypeCborUnmarshallers$ByteBufferCborUnmarshaller
  implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext>
{
  public ByteBuffer unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    return ByteBuffer.wrap(unmarshallerContext.getJsonParser().getBinaryValue());
  }
  
  private static final ByteBufferCborUnmarshaller instance = new ByteBufferCborUnmarshaller();
  
  public static ByteBufferCborUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeCborUnmarshallers.ByteBufferCborUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */