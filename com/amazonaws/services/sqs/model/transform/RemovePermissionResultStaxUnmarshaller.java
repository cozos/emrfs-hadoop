package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.RemovePermissionResult;
import javax.xml.stream.events.XMLEvent;

public class RemovePermissionResultStaxUnmarshaller
  implements Unmarshaller<RemovePermissionResult, StaxUnmarshallerContext>
{
  private static RemovePermissionResultStaxUnmarshaller instance;
  
  public RemovePermissionResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    RemovePermissionResult removePermissionResult = new RemovePermissionResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return removePermissionResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return removePermissionResult;
        }
      }
    }
  }
  
  public static RemovePermissionResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RemovePermissionResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.RemovePermissionResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */