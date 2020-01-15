package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Datapoint;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.GetMetricStatisticsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetMetricStatisticsResultStaxUnmarshaller
  implements Unmarshaller<GetMetricStatisticsResult, StaxUnmarshallerContext>
{
  private static GetMetricStatisticsResultStaxUnmarshaller instance;
  
  public GetMetricStatisticsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetMetricStatisticsResult getMetricStatisticsResult = new GetMetricStatisticsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getMetricStatisticsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Label", targetDepth)) {
          getMetricStatisticsResult.setLabel(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Datapoints", targetDepth)) {
          getMetricStatisticsResult.withDatapoints(new ArrayList());
        } else if (context.testExpression("Datapoints/member", targetDepth)) {
          getMetricStatisticsResult.withDatapoints(new Datapoint[] { DatapointStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getMetricStatisticsResult;
      }
    }
  }
  
  public static GetMetricStatisticsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetMetricStatisticsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.GetMetricStatisticsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */