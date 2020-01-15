package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachUserPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AttachUserPolicyResultStaxUnmarshaller
  implements Unmarshaller<AttachUserPolicyResult, StaxUnmarshallerContext>
{
  private static AttachUserPolicyResultStaxUnmarshaller instance;
  
  public AttachUserPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AttachUserPolicyResult attachUserPolicyResult = new AttachUserPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return attachUserPolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return attachUserPolicyResult;
        }
      }
    }
  }
  
  public static AttachUserPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AttachUserPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachUserPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */