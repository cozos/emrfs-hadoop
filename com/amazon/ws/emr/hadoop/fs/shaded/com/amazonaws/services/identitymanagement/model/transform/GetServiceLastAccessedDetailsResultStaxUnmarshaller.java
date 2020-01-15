package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ServiceLastAccessed;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetServiceLastAccessedDetailsResultStaxUnmarshaller
  implements Unmarshaller<GetServiceLastAccessedDetailsResult, StaxUnmarshallerContext>
{
  private static GetServiceLastAccessedDetailsResultStaxUnmarshaller instance;
  
  public GetServiceLastAccessedDetailsResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetServiceLastAccessedDetailsResult getServiceLastAccessedDetailsResult = new GetServiceLastAccessedDetailsResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getServiceLastAccessedDetailsResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("JobStatus", targetDepth)) {
          getServiceLastAccessedDetailsResult.setJobStatus(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("JobCreationDate", targetDepth)) {
          getServiceLastAccessedDetailsResult.setJobCreationDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("ServicesLastAccessed", targetDepth)) {
          getServiceLastAccessedDetailsResult.withServicesLastAccessed(new ArrayList());
        } else if (context.testExpression("ServicesLastAccessed/member", targetDepth)) {
          getServiceLastAccessedDetailsResult.withServicesLastAccessed(new ServiceLastAccessed[] { ServiceLastAccessedStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("JobCompletionDate", targetDepth)) {
          getServiceLastAccessedDetailsResult.setJobCompletionDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          getServiceLastAccessedDetailsResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          getServiceLastAccessedDetailsResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Error", targetDepth)) {
          getServiceLastAccessedDetailsResult.setError(ErrorDetailsStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getServiceLastAccessedDetailsResult;
      }
    }
  }
  
  public static GetServiceLastAccessedDetailsResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetServiceLastAccessedDetailsResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */