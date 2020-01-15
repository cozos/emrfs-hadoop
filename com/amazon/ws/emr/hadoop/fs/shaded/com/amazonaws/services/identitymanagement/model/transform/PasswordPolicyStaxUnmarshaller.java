package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PasswordPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class PasswordPolicyStaxUnmarshaller
  implements Unmarshaller<PasswordPolicy, StaxUnmarshallerContext>
{
  private static PasswordPolicyStaxUnmarshaller instance;
  
  public PasswordPolicy unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PasswordPolicy passwordPolicy = new PasswordPolicy();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return passwordPolicy;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MinimumPasswordLength", targetDepth)) {
          passwordPolicy.setMinimumPasswordLength(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("RequireSymbols", targetDepth)) {
          passwordPolicy.setRequireSymbols(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("RequireNumbers", targetDepth)) {
          passwordPolicy.setRequireNumbers(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("RequireUppercaseCharacters", targetDepth)) {
          passwordPolicy.setRequireUppercaseCharacters(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("RequireLowercaseCharacters", targetDepth)) {
          passwordPolicy.setRequireLowercaseCharacters(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AllowUsersToChangePassword", targetDepth)) {
          passwordPolicy.setAllowUsersToChangePassword(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ExpirePasswords", targetDepth)) {
          passwordPolicy.setExpirePasswords(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MaxPasswordAge", targetDepth)) {
          passwordPolicy.setMaxPasswordAge(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PasswordReusePrevention", targetDepth)) {
          passwordPolicy.setPasswordReusePrevention(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("HardExpiry", targetDepth)) {
          passwordPolicy.setHardExpiry(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return passwordPolicy;
      }
    }
  }
  
  public static PasswordPolicyStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PasswordPolicyStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PasswordPolicyStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */