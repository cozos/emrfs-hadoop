package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.AnomalyDetector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.Dimension;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class AnomalyDetectorStaxUnmarshaller
  implements Unmarshaller<AnomalyDetector, StaxUnmarshallerContext>
{
  private static AnomalyDetectorStaxUnmarshaller instance;
  
  public AnomalyDetector unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AnomalyDetector anomalyDetector = new AnomalyDetector();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return anomalyDetector;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Namespace", targetDepth)) {
          anomalyDetector.setNamespace(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MetricName", targetDepth)) {
          anomalyDetector.setMetricName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Dimensions", targetDepth)) {
          anomalyDetector.withDimensions(new ArrayList());
        } else if (context.testExpression("Dimensions/member", targetDepth)) {
          anomalyDetector.withDimensions(new Dimension[] { DimensionStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("Stat", targetDepth)) {
          anomalyDetector.setStat(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Configuration", targetDepth)) {
          anomalyDetector.setConfiguration(AnomalyDetectorConfigurationStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return anomalyDetector;
      }
    }
  }
  
  public static AnomalyDetectorStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AnomalyDetectorStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.AnomalyDetectorStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */