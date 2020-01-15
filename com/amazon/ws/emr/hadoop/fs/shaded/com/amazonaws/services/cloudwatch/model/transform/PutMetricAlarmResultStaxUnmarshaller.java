package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.PutMetricAlarmResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class PutMetricAlarmResultStaxUnmarshaller
  implements Unmarshaller<PutMetricAlarmResult, StaxUnmarshallerContext>
{
  private static PutMetricAlarmResultStaxUnmarshaller instance;
  
  public PutMetricAlarmResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PutMetricAlarmResult putMetricAlarmResult = new PutMetricAlarmResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return putMetricAlarmResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return putMetricAlarmResult;
        }
      }
    }
  }
  
  public static PutMetricAlarmResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutMetricAlarmResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.PutMetricAlarmResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */