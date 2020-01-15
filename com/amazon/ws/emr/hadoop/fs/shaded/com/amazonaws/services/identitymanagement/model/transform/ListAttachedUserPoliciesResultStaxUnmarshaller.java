package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedUserPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListAttachedUserPoliciesResultStaxUnmarshaller
  implements Unmarshaller<ListAttachedUserPoliciesResult, StaxUnmarshallerContext>
{
  private static ListAttachedUserPoliciesResultStaxUnmarshaller instance;
  
  public ListAttachedUserPoliciesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListAttachedUserPoliciesResult listAttachedUserPoliciesResult = new ListAttachedUserPoliciesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listAttachedUserPoliciesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AttachedPolicies", targetDepth)) {
          listAttachedUserPoliciesResult.withAttachedPolicies(new ArrayList());
        } else if (context.testExpression("AttachedPolicies/member", targetDepth)) {
          listAttachedUserPoliciesResult.withAttachedPolicies(new AttachedPolicy[] { AttachedPolicyStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listAttachedUserPoliciesResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listAttachedUserPoliciesResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listAttachedUserPoliciesResult;
      }
    }
  }
  
  public static ListAttachedUserPoliciesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListAttachedUserPoliciesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListAttachedUserPoliciesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */