package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AssumeRoleWithSAMLResultStaxUnmarshaller
  implements Unmarshaller<AssumeRoleWithSAMLResult, StaxUnmarshallerContext>
{
  private static AssumeRoleWithSAMLResultStaxUnmarshaller instance;
  
  public AssumeRoleWithSAMLResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AssumeRoleWithSAMLResult assumeRoleWithSAMLResult = new AssumeRoleWithSAMLResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return assumeRoleWithSAMLResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Credentials", targetDepth)) {
          assumeRoleWithSAMLResult.setCredentials(CredentialsStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AssumedRoleUser", targetDepth)) {
          assumeRoleWithSAMLResult.setAssumedRoleUser(AssumedRoleUserStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PackedPolicySize", targetDepth)) {
          assumeRoleWithSAMLResult.setPackedPolicySize(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Subject", targetDepth)) {
          assumeRoleWithSAMLResult.setSubject(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("SubjectType", targetDepth)) {
          assumeRoleWithSAMLResult.setSubjectType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Issuer", targetDepth)) {
          assumeRoleWithSAMLResult.setIssuer(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Audience", targetDepth)) {
          assumeRoleWithSAMLResult.setAudience(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("NameQualifier", targetDepth)) {
          assumeRoleWithSAMLResult.setNameQualifier(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return assumeRoleWithSAMLResult;
      }
    }
  }
  
  public static AssumeRoleWithSAMLResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AssumeRoleWithSAMLResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumeRoleWithSAMLResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */