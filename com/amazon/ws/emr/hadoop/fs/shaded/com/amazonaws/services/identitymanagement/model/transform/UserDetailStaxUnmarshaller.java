package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UserDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class UserDetailStaxUnmarshaller
  implements Unmarshaller<UserDetail, StaxUnmarshallerContext>
{
  private static UserDetailStaxUnmarshaller instance;
  
  public UserDetail unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UserDetail userDetail = new UserDetail();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return userDetail;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Path", targetDepth)) {
          userDetail.setPath(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("UserName", targetDepth)) {
          userDetail.setUserName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("UserId", targetDepth)) {
          userDetail.setUserId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Arn", targetDepth)) {
          userDetail.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("CreateDate", targetDepth)) {
          userDetail.setCreateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("UserPolicyList", targetDepth)) {
          userDetail.withUserPolicyList(new ArrayList());
        } else if (context.testExpression("UserPolicyList/member", targetDepth)) {
          userDetail.withUserPolicyList(new PolicyDetail[] { PolicyDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("GroupList", targetDepth)) {
          userDetail.withGroupList(new ArrayList());
        } else if (context.testExpression("GroupList/member", targetDepth)) {
          userDetail.withGroupList(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("AttachedManagedPolicies", targetDepth)) {
          userDetail.withAttachedManagedPolicies(new ArrayList());
        } else if (context.testExpression("AttachedManagedPolicies/member", targetDepth)) {
          userDetail.withAttachedManagedPolicies(new AttachedPolicy[] { AttachedPolicyStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("PermissionsBoundary", targetDepth)) {
          userDetail.setPermissionsBoundary(AttachedPermissionsBoundaryStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Tags", targetDepth)) {
          userDetail.withTags(new ArrayList());
        } else if (context.testExpression("Tags/member", targetDepth)) {
          userDetail.withTags(new Tag[] { TagStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return userDetail;
      }
    }
  }
  
  public static UserDetailStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UserDetailStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UserDetailStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */