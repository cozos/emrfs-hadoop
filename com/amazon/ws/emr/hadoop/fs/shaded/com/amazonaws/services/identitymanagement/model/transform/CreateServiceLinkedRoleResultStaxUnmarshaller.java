package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceLinkedRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateServiceLinkedRoleResultStaxUnmarshaller
  implements Unmarshaller<CreateServiceLinkedRoleResult, StaxUnmarshallerContext>
{
  private static CreateServiceLinkedRoleResultStaxUnmarshaller instance;
  
  public CreateServiceLinkedRoleResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateServiceLinkedRoleResult createServiceLinkedRoleResult = new CreateServiceLinkedRoleResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createServiceLinkedRoleResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Role", targetDepth)) {
          createServiceLinkedRoleResult.setRole(RoleStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createServiceLinkedRoleResult;
      }
    }
  }
  
  public static CreateServiceLinkedRoleResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateServiceLinkedRoleResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateServiceLinkedRoleResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */