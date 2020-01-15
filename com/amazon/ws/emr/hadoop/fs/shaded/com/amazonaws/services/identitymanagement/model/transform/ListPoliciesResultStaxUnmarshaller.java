package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.Policy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListPoliciesResultStaxUnmarshaller
  implements Unmarshaller<ListPoliciesResult, StaxUnmarshallerContext>
{
  private static ListPoliciesResultStaxUnmarshaller instance;
  
  public ListPoliciesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListPoliciesResult listPoliciesResult = new ListPoliciesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listPoliciesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Policies", targetDepth)) {
          listPoliciesResult.withPolicies(new ArrayList());
        } else if (context.testExpression("Policies/member", targetDepth)) {
          listPoliciesResult.withPolicies(new Policy[] { PolicyStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listPoliciesResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listPoliciesResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listPoliciesResult;
      }
    }
  }
  
  public static ListPoliciesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListPoliciesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */