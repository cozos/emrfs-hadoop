package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDatum;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class MetricDatumStaxUnmarshaller
  implements Unmarshaller<MetricDatum, StaxUnmarshallerContext>
{
  private static MetricDatumStaxUnmarshaller instance;
  
  public MetricDatum unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MetricDatum metricDatum = new MetricDatum();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return metricDatum;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MetricName", targetDepth)) {
          metricDatum.setMetricName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Dimensions", targetDepth)) {
          metricDatum.withDimensions(new ArrayList());
        } else if (context.testExpression("Dimensions/member", targetDepth)) {
          metricDatum.withDimensions(new Dimension[] { DimensionStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("Timestamp", targetDepth)) {
          metricDatum.setTimestamp(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("Value", targetDepth)) {
          metricDatum.setValue(SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("StatisticValues", targetDepth)) {
          metricDatum.setStatisticValues(StatisticSetStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Values", targetDepth)) {
          metricDatum.withValues(new ArrayList());
        } else if (context.testExpression("Values/member", targetDepth)) {
          metricDatum.withValues(new Double[] { SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("Counts", targetDepth)) {
          metricDatum.withCounts(new ArrayList());
        } else if (context.testExpression("Counts/member", targetDepth)) {
          metricDatum.withCounts(new Double[] { SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("Unit", targetDepth)) {
          metricDatum.setUnit(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("StorageResolution", targetDepth)) {
          metricDatum.setStorageResolution(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return metricDatum;
      }
    }
  }
  
  public static MetricDatumStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MetricDatumStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.MetricDatumStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */