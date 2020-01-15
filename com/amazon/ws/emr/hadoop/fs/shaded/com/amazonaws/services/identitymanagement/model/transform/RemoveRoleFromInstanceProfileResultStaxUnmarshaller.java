package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveRoleFromInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class RemoveRoleFromInstanceProfileResultStaxUnmarshaller
  implements Unmarshaller<RemoveRoleFromInstanceProfileResult, StaxUnmarshallerContext>
{
  private static RemoveRoleFromInstanceProfileResultStaxUnmarshaller instance;
  
  public RemoveRoleFromInstanceProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    RemoveRoleFromInstanceProfileResult removeRoleFromInstanceProfileResult = new RemoveRoleFromInstanceProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return removeRoleFromInstanceProfileResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return removeRoleFromInstanceProfileResult;
        }
      }
    }
  }
  
  public static RemoveRoleFromInstanceProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RemoveRoleFromInstanceProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RemoveRoleFromInstanceProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */