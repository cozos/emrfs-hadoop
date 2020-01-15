package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLinkedRoleDeletionStatusResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class GetServiceLinkedRoleDeletionStatusResultStaxUnmarshaller
  implements Unmarshaller<GetServiceLinkedRoleDeletionStatusResult, StaxUnmarshallerContext>
{
  private static GetServiceLinkedRoleDeletionStatusResultStaxUnmarshaller instance;
  
  public GetServiceLinkedRoleDeletionStatusResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    GetServiceLinkedRoleDeletionStatusResult getServiceLinkedRoleDeletionStatusResult = new GetServiceLinkedRoleDeletionStatusResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return getServiceLinkedRoleDeletionStatusResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Status", targetDepth)) {
          getServiceLinkedRoleDeletionStatusResult.setStatus(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Reason", targetDepth)) {
          getServiceLinkedRoleDeletionStatusResult.setReason(DeletionTaskFailureReasonTypeStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return getServiceLinkedRoleDeletionStatusResult;
      }
    }
  }
  
  public static GetServiceLinkedRoleDeletionStatusResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetServiceLinkedRoleDeletionStatusResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.GetServiceLinkedRoleDeletionStatusResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */