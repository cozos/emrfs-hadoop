package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletionTaskFailureReasonType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RoleUsageType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class DeletionTaskFailureReasonTypeStaxUnmarshaller
  implements Unmarshaller<DeletionTaskFailureReasonType, StaxUnmarshallerContext>
{
  private static DeletionTaskFailureReasonTypeStaxUnmarshaller instance;
  
  public DeletionTaskFailureReasonType unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeletionTaskFailureReasonType deletionTaskFailureReasonType = new DeletionTaskFailureReasonType();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deletionTaskFailureReasonType;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Reason", targetDepth)) {
          deletionTaskFailureReasonType.setReason(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("RoleUsageList", targetDepth)) {
          deletionTaskFailureReasonType.withRoleUsageList(new ArrayList());
        } else if (context.testExpression("RoleUsageList/member", targetDepth)) {
          deletionTaskFailureReasonType.withRoleUsageList(new RoleUsageType[] { RoleUsageTypeStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return deletionTaskFailureReasonType;
      }
    }
  }
  
  public static DeletionTaskFailureReasonTypeStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeletionTaskFailureReasonTypeStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeletionTaskFailureReasonTypeStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */