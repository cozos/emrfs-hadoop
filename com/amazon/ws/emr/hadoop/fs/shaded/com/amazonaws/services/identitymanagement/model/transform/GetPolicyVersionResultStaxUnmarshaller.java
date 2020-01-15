package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyVersionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetPolicyVersionResultStaxUnmarshaller
  implements Unmarshaller<GetPolicyVersionResult, StaxUnmarshallerContext>
{
  private static GetPolicyVersionResultStaxUnmarshaller instance;
  
  public GetPolicyVersionResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetPolicyVersionResult getPolicyVersionResult = new GetPolicyVersionResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getPolicyVersionResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PolicyVersion", targetDepth)) {
          getPolicyVersionResult.setPolicyVersion(PolicyVersionStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getPolicyVersionResult;
      }
    }
  }
  
  public static GetPolicyVersionResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetPolicyVersionResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetPolicyVersionResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */