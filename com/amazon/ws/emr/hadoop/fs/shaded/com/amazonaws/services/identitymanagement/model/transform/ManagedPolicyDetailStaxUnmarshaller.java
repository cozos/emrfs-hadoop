package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ManagedPolicyDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyVersion;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ManagedPolicyDetailStaxUnmarshaller
  implements Unmarshaller<ManagedPolicyDetail, StaxUnmarshallerContext>
{
  private static ManagedPolicyDetailStaxUnmarshaller instance;
  
  public ManagedPolicyDetail unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ManagedPolicyDetail managedPolicyDetail = new ManagedPolicyDetail();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return managedPolicyDetail;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PolicyName", targetDepth)) {
          managedPolicyDetail.setPolicyName(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PolicyId", targetDepth)) {
          managedPolicyDetail.setPolicyId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Arn", targetDepth)) {
          managedPolicyDetail.setArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Path", targetDepth)) {
          managedPolicyDetail.setPath(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("DefaultVersionId", targetDepth)) {
          managedPolicyDetail.setDefaultVersionId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AttachmentCount", targetDepth)) {
          managedPolicyDetail.setAttachmentCount(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PermissionsBoundaryUsageCount", targetDepth)) {
          managedPolicyDetail.setPermissionsBoundaryUsageCount(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("IsAttachable", targetDepth)) {
          managedPolicyDetail.setIsAttachable(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Description", targetDepth)) {
          managedPolicyDetail.setDescription(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("CreateDate", targetDepth)) {
          managedPolicyDetail.setCreateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("UpdateDate", targetDepth)) {
          managedPolicyDetail.setUpdateDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("PolicyVersionList", targetDepth)) {
          managedPolicyDetail.withPolicyVersionList(new ArrayList());
        } else if (context.testExpression("PolicyVersionList/member", targetDepth)) {
          managedPolicyDetail.withPolicyVersionList(new PolicyVersion[] { PolicyVersionStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return managedPolicyDetail;
      }
    }
  }
  
  public static ManagedPolicyDetailStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ManagedPolicyDetailStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ManagedPolicyDetailStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */