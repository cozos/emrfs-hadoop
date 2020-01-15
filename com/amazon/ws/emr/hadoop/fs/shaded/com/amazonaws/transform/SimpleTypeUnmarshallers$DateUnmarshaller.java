package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XpathUtils;
import java.util.Date;
import org.w3c.dom.Node;

public class SimpleTypeUnmarshallers$DateUnmarshaller
  implements Unmarshaller<Date, Node>
{
  private static DateUnmarshaller instance;
  
  public Date unmarshall(Node in)
    throws Exception
  {
    return XpathUtils.asDate(".", in);
  }
  
  public static DateUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DateUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeUnmarshallers.DateUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */