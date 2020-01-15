package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountPasswordPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetAccountPasswordPolicyResultStaxUnmarshaller
  implements Unmarshaller<GetAccountPasswordPolicyResult, StaxUnmarshallerContext>
{
  private static GetAccountPasswordPolicyResultStaxUnmarshaller instance;
  
  public GetAccountPasswordPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetAccountPasswordPolicyResult getAccountPasswordPolicyResult = new GetAccountPasswordPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getAccountPasswordPolicyResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PasswordPolicy", targetDepth)) {
          getAccountPasswordPolicyResult.setPasswordPolicy(PasswordPolicyStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getAccountPasswordPolicyResult;
      }
    }
  }
  
  public static GetAccountPasswordPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetAccountPasswordPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountPasswordPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */