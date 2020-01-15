package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccountPasswordPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateAccountPasswordPolicyResultStaxUnmarshaller
  implements Unmarshaller<UpdateAccountPasswordPolicyResult, StaxUnmarshallerContext>
{
  private static UpdateAccountPasswordPolicyResultStaxUnmarshaller instance;
  
  public UpdateAccountPasswordPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateAccountPasswordPolicyResult updateAccountPasswordPolicyResult = new UpdateAccountPasswordPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateAccountPasswordPolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return updateAccountPasswordPolicyResult;
        }
      }
    }
  }
  
  public static UpdateAccountPasswordPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateAccountPasswordPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateAccountPasswordPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */