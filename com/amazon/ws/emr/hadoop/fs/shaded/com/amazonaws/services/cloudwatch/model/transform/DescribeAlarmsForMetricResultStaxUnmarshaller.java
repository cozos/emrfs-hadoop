package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsForMetricResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricAlarm;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class DescribeAlarmsForMetricResultStaxUnmarshaller
  implements Unmarshaller<DescribeAlarmsForMetricResult, StaxUnmarshallerContext>
{
  private static DescribeAlarmsForMetricResultStaxUnmarshaller instance;
  
  public DescribeAlarmsForMetricResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DescribeAlarmsForMetricResult describeAlarmsForMetricResult = new DescribeAlarmsForMetricResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return describeAlarmsForMetricResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MetricAlarms", targetDepth)) {
          describeAlarmsForMetricResult.withMetricAlarms(new ArrayList());
        } else if (context.testExpression("MetricAlarms/member", targetDepth)) {
          describeAlarmsForMetricResult.withMetricAlarms(new MetricAlarm[] { MetricAlarmStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return describeAlarmsForMetricResult;
      }
    }
  }
  
  public static DescribeAlarmsForMetricResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeAlarmsForMetricResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DescribeAlarmsForMetricResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */