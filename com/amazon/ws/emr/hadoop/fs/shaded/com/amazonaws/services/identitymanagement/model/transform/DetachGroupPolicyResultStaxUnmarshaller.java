package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachGroupPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DetachGroupPolicyResultStaxUnmarshaller
  implements Unmarshaller<DetachGroupPolicyResult, StaxUnmarshallerContext>
{
  private static DetachGroupPolicyResultStaxUnmarshaller instance;
  
  public DetachGroupPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DetachGroupPolicyResult detachGroupPolicyResult = new DetachGroupPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return detachGroupPolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return detachGroupPolicyResult;
        }
      }
    }
  }
  
  public static DetachGroupPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DetachGroupPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DetachGroupPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */