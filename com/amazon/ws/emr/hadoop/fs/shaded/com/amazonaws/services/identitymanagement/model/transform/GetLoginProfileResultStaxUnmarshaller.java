package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetLoginProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetLoginProfileResultStaxUnmarshaller
  implements Unmarshaller<GetLoginProfileResult, StaxUnmarshallerContext>
{
  private static GetLoginProfileResultStaxUnmarshaller instance;
  
  public GetLoginProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetLoginProfileResult getLoginProfileResult = new GetLoginProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getLoginProfileResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("LoginProfile", targetDepth)) {
          getLoginProfileResult.setLoginProfile(LoginProfileStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getLoginProfileResult;
      }
    }
  }
  
  public static GetLoginProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetLoginProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetLoginProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */