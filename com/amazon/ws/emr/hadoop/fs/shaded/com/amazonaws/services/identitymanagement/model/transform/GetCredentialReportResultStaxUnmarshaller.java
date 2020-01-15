package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetCredentialReportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetCredentialReportResultStaxUnmarshaller
  implements Unmarshaller<GetCredentialReportResult, StaxUnmarshallerContext>
{
  private static GetCredentialReportResultStaxUnmarshaller instance;
  
  public GetCredentialReportResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetCredentialReportResult getCredentialReportResult = new GetCredentialReportResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getCredentialReportResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Content", targetDepth)) {
          getCredentialReportResult.setContent(SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ReportFormat", targetDepth)) {
          getCredentialReportResult.setReportFormat(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("GeneratedTime", targetDepth)) {
          getCredentialReportResult.setGeneratedTime(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getCredentialReportResult;
      }
    }
  }
  
  public static GetCredentialReportResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetCredentialReportResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetCredentialReportResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */