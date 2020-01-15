package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetAccessKeyInfoResultStaxUnmarshaller
  implements Unmarshaller<GetAccessKeyInfoResult, StaxUnmarshallerContext>
{
  private static GetAccessKeyInfoResultStaxUnmarshaller instance;
  
  public GetAccessKeyInfoResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetAccessKeyInfoResult getAccessKeyInfoResult = new GetAccessKeyInfoResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getAccessKeyInfoResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Account", targetDepth)) {
          getAccessKeyInfoResult.setAccount(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getAccessKeyInfoResult;
      }
    }
  }
  
  public static GetAccessKeyInfoResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetAccessKeyInfoResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetAccessKeyInfoResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */