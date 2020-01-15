package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricStat;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class MetricStatStaxUnmarshaller
  implements Unmarshaller<MetricStat, StaxUnmarshallerContext>
{
  private static MetricStatStaxUnmarshaller instance;
  
  public MetricStat unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MetricStat metricStat = new MetricStat();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return metricStat;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Metric", targetDepth)) {
          metricStat.setMetric(MetricStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Period", targetDepth)) {
          metricStat.setPeriod(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Stat", targetDepth)) {
          metricStat.setStat(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Unit", targetDepth)) {
          metricStat.setUnit(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return metricStat;
      }
    }
  }
  
  public static MetricStatStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MetricStatStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.MetricStatStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */