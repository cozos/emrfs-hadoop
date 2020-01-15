package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MessageData;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.MetricDataResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import java.util.Date;
import javax.xml.stream.events.XMLEvent;

public class MetricDataResultStaxUnmarshaller
  implements Unmarshaller<MetricDataResult, StaxUnmarshallerContext>
{
  private static MetricDataResultStaxUnmarshaller instance;
  
  public MetricDataResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MetricDataResult metricDataResult = new MetricDataResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return metricDataResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          metricDataResult.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Label", targetDepth)) {
          metricDataResult.setLabel(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Timestamps", targetDepth)) {
          metricDataResult.withTimestamps(new ArrayList());
        } else if (context.testExpression("Timestamps/member", targetDepth)) {
          metricDataResult.withTimestamps(new Date[] { SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context) });
        } else if (context.testExpression("Values", targetDepth)) {
          metricDataResult.withValues(new ArrayList());
        } else if (context.testExpression("Values/member", targetDepth)) {
          metricDataResult.withValues(new Double[] { SimpleTypeStaxUnmarshallers.DoubleStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("StatusCode", targetDepth)) {
          metricDataResult.setStatusCode(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Messages", targetDepth)) {
          metricDataResult.withMessages(new ArrayList());
        } else if (context.testExpression("Messages/member", targetDepth)) {
          metricDataResult.withMessages(new MessageData[] { MessageDataStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return metricDataResult;
      }
    }
  }
  
  public static MetricDataResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MetricDataResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.MetricDataResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */