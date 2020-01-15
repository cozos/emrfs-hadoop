package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyGroup;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyRole;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyUser;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListEntitiesForPolicyResultStaxUnmarshaller
  implements Unmarshaller<ListEntitiesForPolicyResult, StaxUnmarshallerContext>
{
  private static ListEntitiesForPolicyResultStaxUnmarshaller instance;
  
  public ListEntitiesForPolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListEntitiesForPolicyResult listEntitiesForPolicyResult = new ListEntitiesForPolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listEntitiesForPolicyResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PolicyGroups", targetDepth)) {
          listEntitiesForPolicyResult.withPolicyGroups(new ArrayList());
        } else if (context.testExpression("PolicyGroups/member", targetDepth)) {
          listEntitiesForPolicyResult.withPolicyGroups(new PolicyGroup[] { PolicyGroupStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("PolicyUsers", targetDepth)) {
          listEntitiesForPolicyResult.withPolicyUsers(new ArrayList());
        } else if (context.testExpression("PolicyUsers/member", targetDepth)) {
          listEntitiesForPolicyResult.withPolicyUsers(new PolicyUser[] { PolicyUserStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("PolicyRoles", targetDepth)) {
          listEntitiesForPolicyResult.withPolicyRoles(new ArrayList());
        } else if (context.testExpression("PolicyRoles/member", targetDepth)) {
          listEntitiesForPolicyResult.withPolicyRoles(new PolicyRole[] { PolicyRoleStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listEntitiesForPolicyResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listEntitiesForPolicyResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listEntitiesForPolicyResult;
      }
    }
  }
  
  public static ListEntitiesForPolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListEntitiesForPolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListEntitiesForPolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */