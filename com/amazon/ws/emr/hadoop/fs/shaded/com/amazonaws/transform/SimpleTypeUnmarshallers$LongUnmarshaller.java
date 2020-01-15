package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$LongUnmarshaller
  implements Unmarshaller<Long, Node>
{
  private static LongUnmarshaller instance;
  
  public Long unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asLong(".", in);
  }
  
  public static LongUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new LongUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.LongUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */