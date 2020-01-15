package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetFederationTokenResultStaxUnmarshaller
  implements Unmarshaller<GetFederationTokenResult, StaxUnmarshallerContext>
{
  private static GetFederationTokenResultStaxUnmarshaller instance;
  
  public GetFederationTokenResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetFederationTokenResult getFederationTokenResult = new GetFederationTokenResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getFederationTokenResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Credentials", targetDepth)) {
          getFederationTokenResult.setCredentials(CredentialsStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("FederatedUser", targetDepth)) {
          getFederationTokenResult.setFederatedUser(FederatedUserStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PackedPolicySize", targetDepth)) {
          getFederationTokenResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getFederationTokenResult;
      }
    }
  }
  
  public static GetFederationTokenResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetFederationTokenResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.GetFederationTokenResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */