package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteRolePermissionsBoundaryResultStaxUnmarshaller
  implements Unmarshaller<DeleteRolePermissionsBoundaryResult, StaxUnmarshallerContext>
{
  private static DeleteRolePermissionsBoundaryResultStaxUnmarshaller instance;
  
  public DeleteRolePermissionsBoundaryResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteRolePermissionsBoundaryResult deleteRolePermissionsBoundaryResult = new DeleteRolePermissionsBoundaryResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteRolePermissionsBoundaryResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteRolePermissionsBoundaryResult;
        }
      }
    }
  }
  
  public static DeleteRolePermissionsBoundaryResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteRolePermissionsBoundaryResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePermissionsBoundaryResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */