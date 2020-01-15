package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GroupDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ManagedPolicyDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RoleDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UserDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetAccountAuthorizationDetailsResultStaxUnmarshaller
  implements Unmarshaller<GetAccountAuthorizationDetailsResult, StaxUnmarshallerContext>
{
  private static GetAccountAuthorizationDetailsResultStaxUnmarshaller instance;
  
  public GetAccountAuthorizationDetailsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetAccountAuthorizationDetailsResult getAccountAuthorizationDetailsResult = new GetAccountAuthorizationDetailsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getAccountAuthorizationDetailsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("UserDetailList", targetDepth)) {
          getAccountAuthorizationDetailsResult.withUserDetailList(new ArrayList());
        } else if (context.testExpression("UserDetailList/member", targetDepth)) {
          getAccountAuthorizationDetailsResult.withUserDetailList(new UserDetail[] { UserDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("GroupDetailList", targetDepth)) {
          getAccountAuthorizationDetailsResult.withGroupDetailList(new ArrayList());
        } else if (context.testExpression("GroupDetailList/member", targetDepth)) {
          getAccountAuthorizationDetailsResult.withGroupDetailList(new GroupDetail[] { GroupDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("RoleDetailList", targetDepth)) {
          getAccountAuthorizationDetailsResult.withRoleDetailList(new ArrayList());
        } else if (context.testExpression("RoleDetailList/member", targetDepth)) {
          getAccountAuthorizationDetailsResult.withRoleDetailList(new RoleDetail[] { RoleDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("Policies", targetDepth)) {
          getAccountAuthorizationDetailsResult.withPolicies(new ArrayList());
        } else if (context.testExpression("Policies/member", targetDepth)) {
          getAccountAuthorizationDetailsResult.withPolicies(new ManagedPolicyDetail[] { ManagedPolicyDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          getAccountAuthorizationDetailsResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          getAccountAuthorizationDetailsResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getAccountAuthorizationDetailsResult;
      }
    }
  }
  
  public static GetAccountAuthorizationDetailsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetAccountAuthorizationDetailsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetAccountAuthorizationDetailsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */