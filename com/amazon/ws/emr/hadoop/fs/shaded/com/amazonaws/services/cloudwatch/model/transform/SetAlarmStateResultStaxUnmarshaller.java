package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.SetAlarmStateResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class SetAlarmStateResultStaxUnmarshaller
  implements Unmarshaller<SetAlarmStateResult, StaxUnmarshallerContext>
{
  private static SetAlarmStateResultStaxUnmarshaller instance;
  
  public SetAlarmStateResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SetAlarmStateResult setAlarmStateResult = new SetAlarmStateResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return setAlarmStateResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return setAlarmStateResult;
        }
      }
    }
  }
  
  public static SetAlarmStateResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SetAlarmStateResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.transform.SetAlarmStateResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */