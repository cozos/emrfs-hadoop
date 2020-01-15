package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AssumeRoleResultStaxUnmarshaller
  implements Unmarshaller<AssumeRoleResult, StaxUnmarshallerContext>
{
  private static AssumeRoleResultStaxUnmarshaller instance;
  
  public AssumeRoleResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AssumeRoleResult assumeRoleResult = new AssumeRoleResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return assumeRoleResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Credentials", targetDepth)) {
          assumeRoleResult.setCredentials(CredentialsStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AssumedRoleUser", targetDepth)) {
          assumeRoleResult.setAssumedRoleUser(AssumedRoleUserStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PackedPolicySize", targetDepth)) {
          assumeRoleResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return assumeRoleResult;
      }
    }
  }
  
  public static AssumeRoleResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AssumeRoleResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */