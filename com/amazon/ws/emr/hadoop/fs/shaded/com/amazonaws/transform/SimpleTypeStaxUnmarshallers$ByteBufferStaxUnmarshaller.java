package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import java.nio.ByteBuffer;

public class SimpleTypeStaxUnmarshallers$ByteBufferStaxUnmarshaller
  implements Unmarshaller<ByteBuffer, StaxUnmarshallerContext>
{
  public ByteBuffer unmarshall(StaxUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String base64EncodedString = unmarshallerContext.readText();
    byte[] decodedBytes = Base64.decode(base64EncodedString);
    return ByteBuffer.wrap(decodedBytes);
  }
  
  private static final ByteBufferStaxUnmarshaller instance = new ByteBufferStaxUnmarshaller();
  
  public static ByteBufferStaxUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */