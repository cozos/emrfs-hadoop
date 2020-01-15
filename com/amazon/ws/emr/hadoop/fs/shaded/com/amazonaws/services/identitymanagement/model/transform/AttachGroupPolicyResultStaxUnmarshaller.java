package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AttachGroupPolicyResultStaxUnmarshaller
  implements Unmarshaller<AttachGroupPolicyResult, StaxUnmarshallerContext>
{
  private static AttachGroupPolicyResultStaxUnmarshaller instance;
  
  public AttachGroupPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AttachGroupPolicyResult attachGroupPolicyResult = new AttachGroupPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return attachGroupPolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return attachGroupPolicyResult;
        }
      }
    }
  }
  
  public static AttachGroupPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AttachGroupPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachGroupPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */