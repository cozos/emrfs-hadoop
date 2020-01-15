package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EntityDetails;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsWithEntitiesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class GetServiceLastAccessedDetailsWithEntitiesResultStaxUnmarshaller
  implements Unmarshaller<GetServiceLastAccessedDetailsWithEntitiesResult, StaxUnmarshallerContext>
{
  private static GetServiceLastAccessedDetailsWithEntitiesResultStaxUnmarshaller instance;
  
  public GetServiceLastAccessedDetailsWithEntitiesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetServiceLastAccessedDetailsWithEntitiesResult getServiceLastAccessedDetailsWithEntitiesResult = new GetServiceLastAccessedDetailsWithEntitiesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getServiceLastAccessedDetailsWithEntitiesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("JobStatus", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.setJobStatus(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("JobCreationDate", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.setJobCreationDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("JobCompletionDate", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.setJobCompletionDate(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        } else if (context.testExpression("EntityDetailsList", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.withEntityDetailsList(new ArrayList());
        } else if (context.testExpression("EntityDetailsList/member", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.withEntityDetailsList(new EntityDetails[] { EntityDetailsStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("IsTruncated", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.setIsTruncated(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Marker", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.setMarker(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Error", targetDepth)) {
          getServiceLastAccessedDetailsWithEntitiesResult.setError(ErrorDetailsStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getServiceLastAccessedDetailsWithEntitiesResult;
      }
    }
  }
  
  public static GetServiceLastAccessedDetailsWithEntitiesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetServiceLastAccessedDetailsWithEntitiesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLastAccessedDetailsWithEntitiesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */