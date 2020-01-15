package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumedRoleUser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AssumedRoleUserStaxUnmarshaller
  implements Unmarshaller<AssumedRoleUser, StaxUnmarshallerContext>
{
  private static AssumedRoleUserStaxUnmarshaller instance;
  
  public AssumedRoleUser unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AssumedRoleUser assumedRoleUser = new AssumedRoleUser();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return assumedRoleUser;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AssumedRoleId", targetDepth)) {
          assumedRoleUser.setAssumedRoleId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Arn", targetDepth)) {
          assumedRoleUser.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return assumedRoleUser;
      }
    }
  }
  
  public static AssumedRoleUserStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AssumedRoleUserStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.transform.AssumedRoleUserStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */