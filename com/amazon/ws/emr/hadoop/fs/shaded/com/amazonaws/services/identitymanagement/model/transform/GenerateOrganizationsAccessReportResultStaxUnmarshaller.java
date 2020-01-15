package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GenerateOrganizationsAccessReportResultStaxUnmarshaller
  implements Unmarshaller<GenerateOrganizationsAccessReportResult, StaxUnmarshallerContext>
{
  private static GenerateOrganizationsAccessReportResultStaxUnmarshaller instance;
  
  public GenerateOrganizationsAccessReportResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GenerateOrganizationsAccessReportResult generateOrganizationsAccessReportResult = new GenerateOrganizationsAccessReportResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return generateOrganizationsAccessReportResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("JobId", targetDepth)) {
          generateOrganizationsAccessReportResult.setJobId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return generateOrganizationsAccessReportResult;
      }
    }
  }
  
  public static GenerateOrganizationsAccessReportResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GenerateOrganizationsAccessReportResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GenerateOrganizationsAccessReportResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */