package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AttachRolePolicyResultStaxUnmarshaller
  implements Unmarshaller<AttachRolePolicyResult, StaxUnmarshallerContext>
{
  private static AttachRolePolicyResultStaxUnmarshaller instance;
  
  public AttachRolePolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AttachRolePolicyResult attachRolePolicyResult = new AttachRolePolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return attachRolePolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return attachRolePolicyResult;
        }
      }
    }
  }
  
  public static AttachRolePolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AttachRolePolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachRolePolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */