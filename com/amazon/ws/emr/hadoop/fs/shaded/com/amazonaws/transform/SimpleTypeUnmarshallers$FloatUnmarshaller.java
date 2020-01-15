package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$FloatUnmarshaller
  implements Unmarshaller<Float, Node>
{
  private static FloatUnmarshaller instance;
  
  public Float unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asFloat(".", in);
  }
  
  public static FloatUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new FloatUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.FloatUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */