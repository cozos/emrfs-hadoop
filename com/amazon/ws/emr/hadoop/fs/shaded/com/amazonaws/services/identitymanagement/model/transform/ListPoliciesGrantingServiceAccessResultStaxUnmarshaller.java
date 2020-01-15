package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class ListPoliciesGrantingServiceAccessResultStaxUnmarshaller
  implements Unmarshaller<ListPoliciesGrantingServiceAccessResult, StaxUnmarshallerContext>
{
  private static ListPoliciesGrantingServiceAccessResultStaxUnmarshaller instance;
  
  public ListPoliciesGrantingServiceAccessResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListPoliciesGrantingServiceAccessResult listPoliciesGrantingServiceAccessResult = new ListPoliciesGrantingServiceAccessResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listPoliciesGrantingServiceAccessResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PoliciesGrantingServiceAccess", targetDepth)) {
          listPoliciesGrantingServiceAccessResult.withPoliciesGrantingServiceAccess(new ArrayList());
        } else if (context.testExpression("PoliciesGrantingServiceAccess/member", targetDepth)) {
          listPoliciesGrantingServiceAccessResult.withPoliciesGrantingServiceAccess(new ListPoliciesGrantingServiceAccessEntry[] {
            ListPoliciesGrantingServiceAccessEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          listPoliciesGrantingServiceAccessResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          listPoliciesGrantingServiceAccessResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listPoliciesGrantingServiceAccessResult;
      }
    }
  }
  
  public static ListPoliciesGrantingServiceAccessResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListPoliciesGrantingServiceAccessResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.ListPoliciesGrantingServiceAccessResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */