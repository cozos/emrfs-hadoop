package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricAlarm;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class DescribeAlarmsResultStaxUnmarshaller
  implements Unmarshaller<DescribeAlarmsResult, StaxUnmarshallerContext>
{
  private static DescribeAlarmsResultStaxUnmarshaller instance;
  
  public DescribeAlarmsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DescribeAlarmsResult describeAlarmsResult = new DescribeAlarmsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return describeAlarmsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MetricAlarms", targetDepth)) {
          describeAlarmsResult.withMetricAlarms(new ArrayList());
        } else if (context.testExpression("MetricAlarms/member", targetDepth)) {
          describeAlarmsResult.withMetricAlarms(new MetricAlarm[] { MetricAlarmStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("NextToken", targetDepth)) {
          describeAlarmsResult.setNextToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return describeAlarmsResult;
      }
    }
  }
  
  public static DescribeAlarmsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeAlarmsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */