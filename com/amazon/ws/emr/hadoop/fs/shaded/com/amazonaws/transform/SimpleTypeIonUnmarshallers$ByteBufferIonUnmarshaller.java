package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonParser;
import java.nio.ByteBuffer;

public class SimpleTypeIonUnmarshallers$ByteBufferIonUnmarshaller
  implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext>
{
  public ByteBuffer unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    return (ByteBuffer)context.getJsonParser().getEmbeddedObject();
  }
  
  private static final ByteBufferIonUnmarshaller instance = new ByteBufferIonUnmarshaller();
  
  public static ByteBufferIonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeIonUnmarshallers.ByteBufferIonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */