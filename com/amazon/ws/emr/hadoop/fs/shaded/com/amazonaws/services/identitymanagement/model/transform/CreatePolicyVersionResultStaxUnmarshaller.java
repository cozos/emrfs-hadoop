package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreatePolicyVersionResultStaxUnmarshaller
  implements Unmarshaller<CreatePolicyVersionResult, StaxUnmarshallerContext>
{
  private static CreatePolicyVersionResultStaxUnmarshaller instance;
  
  public CreatePolicyVersionResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreatePolicyVersionResult createPolicyVersionResult = new CreatePolicyVersionResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createPolicyVersionResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PolicyVersion", targetDepth)) {
          createPolicyVersionResult.setPolicyVersion(PolicyVersionStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createPolicyVersionResult;
      }
    }
  }
  
  public static CreatePolicyVersionResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreatePolicyVersionResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreatePolicyVersionResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */