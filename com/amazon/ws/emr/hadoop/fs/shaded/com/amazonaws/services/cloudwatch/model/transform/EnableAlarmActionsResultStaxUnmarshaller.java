package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.EnableAlarmActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class EnableAlarmActionsResultStaxUnmarshaller
  implements Unmarshaller<EnableAlarmActionsResult, StaxUnmarshallerContext>
{
  private static EnableAlarmActionsResultStaxUnmarshaller instance;
  
  public EnableAlarmActionsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    EnableAlarmActionsResult enableAlarmActionsResult = new EnableAlarmActionsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return enableAlarmActionsResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return enableAlarmActionsResult;
        }
      }
    }
  }
  
  public static EnableAlarmActionsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EnableAlarmActionsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.EnableAlarmActionsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */