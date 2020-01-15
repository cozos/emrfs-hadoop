package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$BooleanUnmarshaller
  implements Unmarshaller<Boolean, Node>
{
  private static BooleanUnmarshaller instance;
  
  public Boolean unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asBoolean(".", in);
  }
  
  public static BooleanUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BooleanUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.BooleanUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */