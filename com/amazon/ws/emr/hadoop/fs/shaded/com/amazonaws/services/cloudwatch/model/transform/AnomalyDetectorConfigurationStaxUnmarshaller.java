package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AnomalyDetectorConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Range;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class AnomalyDetectorConfigurationStaxUnmarshaller
  implements Unmarshaller<AnomalyDetectorConfiguration, StaxUnmarshallerContext>
{
  private static AnomalyDetectorConfigurationStaxUnmarshaller instance;
  
  public AnomalyDetectorConfiguration unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AnomalyDetectorConfiguration anomalyDetectorConfiguration = new AnomalyDetectorConfiguration();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return anomalyDetectorConfiguration;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ExcludedTimeRanges", targetDepth)) {
          anomalyDetectorConfiguration.withExcludedTimeRanges(new ArrayList());
        } else if (context.testExpression("ExcludedTimeRanges/member", targetDepth)) {
          anomalyDetectorConfiguration.withExcludedTimeRanges(new Range[] { RangeStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("MetricTimezone", targetDepth)) {
          anomalyDetectorConfiguration.setMetricTimezone(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return anomalyDetectorConfiguration;
      }
    }
  }
  
  public static AnomalyDetectorConfigurationStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AnomalyDetectorConfigurationStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.AnomalyDetectorConfigurationStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */