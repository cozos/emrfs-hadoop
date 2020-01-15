package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PolicyGrantingServiceAccess;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListPoliciesGrantingServiceAccessEntryStaxUnmarshaller
  implements Unmarshaller<ListPoliciesGrantingServiceAccessEntry, StaxUnmarshallerContext>
{
  private static ListPoliciesGrantingServiceAccessEntryStaxUnmarshaller instance;
  
  public ListPoliciesGrantingServiceAccessEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListPoliciesGrantingServiceAccessEntry listPoliciesGrantingServiceAccessEntry = new ListPoliciesGrantingServiceAccessEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listPoliciesGrantingServiceAccessEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ServiceNamespace", targetDepth)) {
          listPoliciesGrantingServiceAccessEntry.setServiceNamespace(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Policies", targetDepth)) {
          listPoliciesGrantingServiceAccessEntry.withPolicies(new ArrayList());
        } else if (context.testExpression("Policies/member", targetDepth)) {
          listPoliciesGrantingServiceAccessEntry.withPolicies(new PolicyGrantingServiceAccess[] { PolicyGrantingServiceAccessStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listPoliciesGrantingServiceAccessEntry;
      }
    }
  }
  
  public static ListPoliciesGrantingServiceAccessEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListPoliciesGrantingServiceAccessEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesGrantingServiceAccessEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */