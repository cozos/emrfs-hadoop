package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveUserFromGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class RemoveUserFromGroupResultStaxUnmarshaller
  implements Unmarshaller<RemoveUserFromGroupResult, StaxUnmarshallerContext>
{
  private static RemoveUserFromGroupResultStaxUnmarshaller instance;
  
  public RemoveUserFromGroupResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    RemoveUserFromGroupResult removeUserFromGroupResult = new RemoveUserFromGroupResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return removeUserFromGroupResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return removeUserFromGroupResult;
        }
      }
    }
  }
  
  public static RemoveUserFromGroupResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RemoveUserFromGroupResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveUserFromGroupResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */