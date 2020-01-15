package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DisableAlarmActionsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DisableAlarmActionsResultStaxUnmarshaller
  implements Unmarshaller<DisableAlarmActionsResult, StaxUnmarshallerContext>
{
  private static DisableAlarmActionsResultStaxUnmarshaller instance;
  
  public DisableAlarmActionsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DisableAlarmActionsResult disableAlarmActionsResult = new DisableAlarmActionsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return disableAlarmActionsResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return disableAlarmActionsResult;
        }
      }
    }
  }
  
  public static DisableAlarmActionsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DisableAlarmActionsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.DisableAlarmActionsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */