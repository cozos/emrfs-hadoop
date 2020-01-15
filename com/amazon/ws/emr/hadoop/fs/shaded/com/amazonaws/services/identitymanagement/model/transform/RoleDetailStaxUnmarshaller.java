package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.InstanceProfile;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RoleDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Tag;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class RoleDetailStaxUnmarshaller
  implements Unmarshaller<RoleDetail, StaxUnmarshallerContext>
{
  private static RoleDetailStaxUnmarshaller instance;
  
  public RoleDetail unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    RoleDetail roleDetail = new RoleDetail();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return roleDetail;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Path", targetDepth)) {
          roleDetail.setPath(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("RoleName", targetDepth)) {
          roleDetail.setRoleName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("RoleId", targetDepth)) {
          roleDetail.setRoleId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Arn", targetDepth)) {
          roleDetail.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("CreateDate", targetDepth)) {
          roleDetail.setCreateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("AssumeRolePolicyDocument", targetDepth)) {
          roleDetail.setAssumeRolePolicyDocument(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("InstanceProfileList", targetDepth)) {
          roleDetail.withInstanceProfileList(new ArrayList());
        } else if (context.testExpression("InstanceProfileList/member", targetDepth)) {
          roleDetail.withInstanceProfileList(new InstanceProfile[] { InstanceProfileStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("RolePolicyList", targetDepth)) {
          roleDetail.withRolePolicyList(new ArrayList());
        } else if (context.testExpression("RolePolicyList/member", targetDepth)) {
          roleDetail.withRolePolicyList(new PolicyDetail[] { PolicyDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("AttachedManagedPolicies", targetDepth)) {
          roleDetail.withAttachedManagedPolicies(new ArrayList());
        } else if (context.testExpression("AttachedManagedPolicies/member", targetDepth)) {
          roleDetail.withAttachedManagedPolicies(new AttachedPolicy[] { AttachedPolicyStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("PermissionsBoundary", targetDepth)) {
          roleDetail.setPermissionsBoundary(AttachedPermissionsBoundaryStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Tags", targetDepth)) {
          roleDetail.withTags(new ArrayList());
        } else if (context.testExpression("Tags/member", targetDepth)) {
          roleDetail.withTags(new Tag[] { TagStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return roleDetail;
      }
    }
  }
  
  public static RoleDetailStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RoleDetailStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RoleDetailStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */