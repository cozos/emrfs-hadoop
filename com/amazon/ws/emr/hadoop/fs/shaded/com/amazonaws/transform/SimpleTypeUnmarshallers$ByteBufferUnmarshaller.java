package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import java.nio.ByteBuffer;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$ByteBufferUnmarshaller
  implements Unmarshaller<ByteBuffer, Node>
{
  private static ByteBufferUnmarshaller instance;
  
  public ByteBuffer unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asByteBuffer(".", in);
  }
  
  public static ByteBufferUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ByteBufferUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.ByteBufferUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */