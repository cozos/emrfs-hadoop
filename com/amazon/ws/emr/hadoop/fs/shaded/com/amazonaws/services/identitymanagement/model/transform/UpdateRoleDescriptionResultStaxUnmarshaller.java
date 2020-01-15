package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleDescriptionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class UpdateRoleDescriptionResultStaxUnmarshaller
  implements Unmarshaller<UpdateRoleDescriptionResult, StaxUnmarshallerContext>
{
  private static UpdateRoleDescriptionResultStaxUnmarshaller instance;
  
  public UpdateRoleDescriptionResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UpdateRoleDescriptionResult updateRoleDescriptionResult = new UpdateRoleDescriptionResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return updateRoleDescriptionResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Role", targetDepth)) {
          updateRoleDescriptionResult.setRole(RoleStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return updateRoleDescriptionResult;
      }
    }
  }
  
  public static UpdateRoleDescriptionResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateRoleDescriptionResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.UpdateRoleDescriptionResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */