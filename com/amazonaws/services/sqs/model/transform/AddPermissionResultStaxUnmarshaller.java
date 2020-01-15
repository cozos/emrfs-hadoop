package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.AddPermissionResult;
import javax.xml.stream.events.XMLEvent;

public class AddPermissionResultStaxUnmarshaller
  implements Unmarshaller<AddPermissionResult, StaxUnmarshallerContext>
{
  private static AddPermissionResultStaxUnmarshaller instance;
  
  public AddPermissionResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AddPermissionResult addPermissionResult = new AddPermissionResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return addPermissionResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return addPermissionResult;
        }
      }
    }
  }
  
  public static AddPermissionResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddPermissionResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.AddPermissionResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */