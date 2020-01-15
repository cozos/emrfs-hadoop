package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccessKeyLastUsedResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetAccessKeyLastUsedResultStaxUnmarshaller
  implements Unmarshaller<GetAccessKeyLastUsedResult, StaxUnmarshallerContext>
{
  private static GetAccessKeyLastUsedResultStaxUnmarshaller instance;
  
  public GetAccessKeyLastUsedResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetAccessKeyLastUsedResult getAccessKeyLastUsedResult = new GetAccessKeyLastUsedResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getAccessKeyLastUsedResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("UserName", targetDepth)) {
          getAccessKeyLastUsedResult.setUserName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AccessKeyLastUsed", targetDepth)) {
          getAccessKeyLastUsedResult.setAccessKeyLastUsed(AccessKeyLastUsedStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getAccessKeyLastUsedResult;
      }
    }
  }
  
  public static GetAccessKeyLastUsedResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetAccessKeyLastUsedResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccessKeyLastUsedResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */