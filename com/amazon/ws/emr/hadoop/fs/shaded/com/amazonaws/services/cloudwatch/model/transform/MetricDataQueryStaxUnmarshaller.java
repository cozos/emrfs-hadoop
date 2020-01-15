package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataQuery;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class MetricDataQueryStaxUnmarshaller
  implements Unmarshaller<MetricDataQuery, StaxUnmarshallerContext>
{
  private static MetricDataQueryStaxUnmarshaller instance;
  
  public MetricDataQuery unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MetricDataQuery metricDataQuery = new MetricDataQuery();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return metricDataQuery;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          metricDataQuery.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MetricStat", targetDepth)) {
          metricDataQuery.setMetricStat(MetricStatStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Expression", targetDepth)) {
          metricDataQuery.setExpression(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Label", targetDepth)) {
          metricDataQuery.setLabel(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ReturnData", targetDepth)) {
          metricDataQuery.setReturnData(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Period", targetDepth)) {
          metricDataQuery.setPeriod(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return metricDataQuery;
      }
    }
  }
  
  public static MetricDataQueryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MetricDataQueryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.MetricDataQueryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */