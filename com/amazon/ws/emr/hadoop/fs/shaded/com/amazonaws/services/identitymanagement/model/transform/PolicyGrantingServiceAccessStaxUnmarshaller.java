package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyGrantingServiceAccess;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class PolicyGrantingServiceAccessStaxUnmarshaller
  implements Unmarshaller<PolicyGrantingServiceAccess, StaxUnmarshallerContext>
{
  private static PolicyGrantingServiceAccessStaxUnmarshaller instance;
  
  public PolicyGrantingServiceAccess unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PolicyGrantingServiceAccess policyGrantingServiceAccess = new PolicyGrantingServiceAccess();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return policyGrantingServiceAccess;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PolicyName", targetDepth)) {
          policyGrantingServiceAccess.setPolicyName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PolicyType", targetDepth)) {
          policyGrantingServiceAccess.setPolicyType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PolicyArn", targetDepth)) {
          policyGrantingServiceAccess.setPolicyArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("EntityType", targetDepth)) {
          policyGrantingServiceAccess.setEntityType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("EntityName", targetDepth)) {
          policyGrantingServiceAccess.setEntityName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return policyGrantingServiceAccess;
      }
    }
  }
  
  public static PolicyGrantingServiceAccessStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PolicyGrantingServiceAccessStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PolicyGrantingServiceAccessStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */