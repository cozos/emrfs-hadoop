package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DashboardValidationMessage;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutDashboardResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class PutDashboardResultStaxUnmarshaller
  implements Unmarshaller<PutDashboardResult, StaxUnmarshallerContext>
{
  private static PutDashboardResultStaxUnmarshaller instance;
  
  public PutDashboardResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PutDashboardResult putDashboardResult = new PutDashboardResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return putDashboardResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("DashboardValidationMessages", targetDepth)) {
          putDashboardResult.withDashboardValidationMessages(new ArrayList());
        } else if (context.testExpression("DashboardValidationMessages/member", targetDepth)) {
          putDashboardResult.withDashboardValidationMessages(new DashboardValidationMessage[] { DashboardValidationMessageStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return putDashboardResult;
      }
    }
  }
  
  public static PutDashboardResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutDashboardResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutDashboardResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */