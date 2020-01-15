package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.Base64;
import java.nio.ByteBuffer;

public class SimpleTypeJsonUnmarshallers$ByteBufferJsonUnmarshaller
  implements Unmarshaller<ByteBuffer, JsonUnmarshallerContext>
{
  public ByteBuffer unmarshall(JsonUnmarshallerContext unmarshallerContext)
    throws Exception
  {
    String base64EncodedString = unmarshallerContext.readText();
    if (base64EncodedString == null) {
      return null;
    }
    byte[] decodedBytes = Base64.decode(base64EncodedString);
    return ByteBuffer.wrap(decodedBytes);
  }
  
  private static final ByteBufferJsonUnmarshaller instance = new ByteBufferJsonUnmarshaller();
  
  public static ByteBufferJsonUnmarshaller getInstance()
  {
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.ByteBufferJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */