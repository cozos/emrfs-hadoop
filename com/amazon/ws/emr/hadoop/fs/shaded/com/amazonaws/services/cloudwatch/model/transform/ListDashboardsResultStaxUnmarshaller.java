package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DashboardEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListDashboardsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListDashboardsResultStaxUnmarshaller
  implements Unmarshaller<ListDashboardsResult, StaxUnmarshallerContext>
{
  private static ListDashboardsResultStaxUnmarshaller instance;
  
  public ListDashboardsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListDashboardsResult listDashboardsResult = new ListDashboardsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listDashboardsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("DashboardEntries", targetDepth)) {
          listDashboardsResult.withDashboardEntries(new ArrayList());
        } else if (context.testExpression("DashboardEntries/member", targetDepth)) {
          listDashboardsResult.withDashboardEntries(new DashboardEntry[] { DashboardEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("NextToken", targetDepth)) {
          listDashboardsResult.setNextToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listDashboardsResult;
      }
    }
  }
  
  public static ListDashboardsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListDashboardsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListDashboardsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */