package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GroupDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GroupDetailStaxUnmarshaller
  implements Unmarshaller<GroupDetail, StaxUnmarshallerContext>
{
  private static GroupDetailStaxUnmarshaller instance;
  
  public GroupDetail unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GroupDetail groupDetail = new GroupDetail();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return groupDetail;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Path", targetDepth)) {
          groupDetail.setPath(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("GroupName", targetDepth)) {
          groupDetail.setGroupName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("GroupId", targetDepth)) {
          groupDetail.setGroupId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Arn", targetDepth)) {
          groupDetail.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("CreateDate", targetDepth)) {
          groupDetail.setCreateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("GroupPolicyList", targetDepth)) {
          groupDetail.withGroupPolicyList(new ArrayList());
        } else if (context.testExpression("GroupPolicyList/member", targetDepth)) {
          groupDetail.withGroupPolicyList(new PolicyDetail[] { PolicyDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("AttachedManagedPolicies", targetDepth)) {
          groupDetail.withAttachedManagedPolicies(new ArrayList());
        } else if (context.testExpression("AttachedManagedPolicies/member", targetDepth)) {
          groupDetail.withAttachedManagedPolicies(new AttachedPolicy[] { AttachedPolicyStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return groupDetail;
      }
    }
  }
  
  public static GroupDetailStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GroupDetailStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GroupDetailStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */