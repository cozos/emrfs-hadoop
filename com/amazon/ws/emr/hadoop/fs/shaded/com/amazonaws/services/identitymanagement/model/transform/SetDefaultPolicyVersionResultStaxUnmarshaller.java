package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetDefaultPolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class SetDefaultPolicyVersionResultStaxUnmarshaller
  implements Unmarshaller<SetDefaultPolicyVersionResult, StaxUnmarshallerContext>
{
  private static SetDefaultPolicyVersionResultStaxUnmarshaller instance;
  
  public SetDefaultPolicyVersionResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SetDefaultPolicyVersionResult setDefaultPolicyVersionResult = new SetDefaultPolicyVersionResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return setDefaultPolicyVersionResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return setDefaultPolicyVersionResult;
        }
      }
    }
  }
  
  public static SetDefaultPolicyVersionResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SetDefaultPolicyVersionResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.SetDefaultPolicyVersionResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */