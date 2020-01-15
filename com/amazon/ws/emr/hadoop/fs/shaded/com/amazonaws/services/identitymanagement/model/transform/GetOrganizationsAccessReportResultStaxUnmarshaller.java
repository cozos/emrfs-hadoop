package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AccessDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetOrganizationsAccessReportResultStaxUnmarshaller
  implements Unmarshaller<GetOrganizationsAccessReportResult, StaxUnmarshallerContext>
{
  private static GetOrganizationsAccessReportResultStaxUnmarshaller instance;
  
  public GetOrganizationsAccessReportResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetOrganizationsAccessReportResult getOrganizationsAccessReportResult = new GetOrganizationsAccessReportResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getOrganizationsAccessReportResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("JobStatus", targetDepth)) {
          getOrganizationsAccessReportResult.setJobStatus(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("JobCreationDate", targetDepth)) {
          getOrganizationsAccessReportResult.setJobCreationDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("JobCompletionDate", targetDepth)) {
          getOrganizationsAccessReportResult.setJobCompletionDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("NumberOfServicesAccessible", targetDepth)) {
          getOrganizationsAccessReportResult.setNumberOfServicesAccessible(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("NumberOfServicesNotAccessed", targetDepth)) {
          getOrganizationsAccessReportResult.setNumberOfServicesNotAccessed(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("AccessDetails", targetDepth)) {
          getOrganizationsAccessReportResult.withAccessDetails(new ArrayList());
        } else if (context.testExpression("AccessDetails/member", targetDepth)) {
          getOrganizationsAccessReportResult.withAccessDetails(new AccessDetail[] { AccessDetailStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          getOrganizationsAccessReportResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          getOrganizationsAccessReportResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ErrorDetails", targetDepth)) {
          getOrganizationsAccessReportResult.setErrorDetails(ErrorDetailsStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getOrganizationsAccessReportResult;
      }
    }
  }
  
  public static GetOrganizationsAccessReportResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetOrganizationsAccessReportResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetOrganizationsAccessReportResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */