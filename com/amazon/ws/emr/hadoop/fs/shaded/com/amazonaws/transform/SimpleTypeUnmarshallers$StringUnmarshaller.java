package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$StringUnmarshaller
  implements Unmarshaller<String, Node>
{
  private static StringUnmarshaller instance;
  
  public String unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asString(".", in);
  }
  
  public static StringUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StringUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.StringUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */