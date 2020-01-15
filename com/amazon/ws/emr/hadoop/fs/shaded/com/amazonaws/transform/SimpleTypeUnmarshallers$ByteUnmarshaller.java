package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$ByteUnmarshaller
  implements Unmarshaller<Byte, Node>
{
  private static ByteUnmarshaller instance;
  
  public Byte unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asByte(".", in);
  }
  
  public static ByteUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ByteUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.ByteUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */