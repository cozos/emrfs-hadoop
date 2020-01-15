package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListAttachedGroupPoliciesResultStaxUnmarshaller
  implements Unmarshaller<ListAttachedGroupPoliciesResult, StaxUnmarshallerContext>
{
  private static ListAttachedGroupPoliciesResultStaxUnmarshaller instance;
  
  public ListAttachedGroupPoliciesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListAttachedGroupPoliciesResult listAttachedGroupPoliciesResult = new ListAttachedGroupPoliciesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listAttachedGroupPoliciesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AttachedPolicies", targetDepth)) {
          listAttachedGroupPoliciesResult.withAttachedPolicies(new ArrayList());
        } else if (context.testExpression("AttachedPolicies/member", targetDepth)) {
          listAttachedGroupPoliciesResult.withAttachedPolicies(new AttachedPolicy[] { AttachedPolicyStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listAttachedGroupPoliciesResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listAttachedGroupPoliciesResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listAttachedGroupPoliciesResult;
      }
    }
  }
  
  public static ListAttachedGroupPoliciesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListAttachedGroupPoliciesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedGroupPoliciesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */