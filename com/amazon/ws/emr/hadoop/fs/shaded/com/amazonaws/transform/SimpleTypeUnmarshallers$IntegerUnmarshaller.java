package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$IntegerUnmarshaller
  implements Unmarshaller<Integer, Node>
{
  private static IntegerUnmarshaller instance;
  
  public Integer unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asInteger(".", in);
  }
  
  public static IntegerUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new IntegerUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.IntegerUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */