package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$DoubleUnmarshaller
  implements Unmarshaller<Double, Node>
{
  private static DoubleUnmarshaller instance;
  
  public Double unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asDouble(".", in);
  }
  
  public static DoubleUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DoubleUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.DoubleUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */