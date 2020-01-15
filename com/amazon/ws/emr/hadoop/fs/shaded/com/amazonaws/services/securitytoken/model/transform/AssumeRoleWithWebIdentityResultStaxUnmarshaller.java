package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AssumeRoleWithWebIdentityResultStaxUnmarshaller
  implements Unmarshaller<AssumeRoleWithWebIdentityResult, StaxUnmarshallerContext>
{
  private static AssumeRoleWithWebIdentityResultStaxUnmarshaller instance;
  
  public AssumeRoleWithWebIdentityResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AssumeRoleWithWebIdentityResult assumeRoleWithWebIdentityResult = new AssumeRoleWithWebIdentityResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return assumeRoleWithWebIdentityResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Credentials", targetDepth)) {
          assumeRoleWithWebIdentityResult.setCredentials(CredentialsStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("SubjectFromWebIdentityToken", targetDepth)) {
          assumeRoleWithWebIdentityResult.setSubjectFromWebIdentityToken(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AssumedRoleUser", targetDepth)) {
          assumeRoleWithWebIdentityResult.setAssumedRoleUser(AssumedRoleUserStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PackedPolicySize", targetDepth)) {
          assumeRoleWithWebIdentityResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Provider", targetDepth)) {
          assumeRoleWithWebIdentityResult.setProvider(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Audience", targetDepth)) {
          assumeRoleWithWebIdentityResult.setAudience(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return assumeRoleWithWebIdentityResult;
      }
    }
  }
  
  public static AssumeRoleWithWebIdentityResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AssumeRoleWithWebIdentityResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithWebIdentityResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */