package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.ListMetricsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Metric;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListMetricsResultStaxUnmarshaller
  implements Unmarshaller<ListMetricsResult, StaxUnmarshallerContext>
{
  private static ListMetricsResultStaxUnmarshaller instance;
  
  public ListMetricsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListMetricsResult listMetricsResult = new ListMetricsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listMetricsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Metrics", targetDepth)) {
          listMetricsResult.withMetrics(new ArrayList());
        } else if (context.testExpression("Metrics/member", targetDepth)) {
          listMetricsResult.withMetrics(new Metric[] { MetricStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("NextToken", targetDepth)) {
          listMetricsResult.setNextToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listMetricsResult;
      }
    }
  }
  
  public static ListMetricsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListMetricsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.ListMetricsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */