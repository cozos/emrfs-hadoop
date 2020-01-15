package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.OrganizationsDecisionDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class OrganizationsDecisionDetailStaxUnmarshaller
  implements Unmarshaller<OrganizationsDecisionDetail, StaxUnmarshallerContext>
{
  private static OrganizationsDecisionDetailStaxUnmarshaller instance;
  
  public OrganizationsDecisionDetail unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    OrganizationsDecisionDetail organizationsDecisionDetail = new OrganizationsDecisionDetail();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return organizationsDecisionDetail;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AllowedByOrganizations", targetDepth)) {
          organizationsDecisionDetail.setAllowedByOrganizations(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return organizationsDecisionDetail;
      }
    }
  }
  
  public static OrganizationsDecisionDetailStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new OrganizationsDecisionDetailStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.OrganizationsDecisionDetailStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */