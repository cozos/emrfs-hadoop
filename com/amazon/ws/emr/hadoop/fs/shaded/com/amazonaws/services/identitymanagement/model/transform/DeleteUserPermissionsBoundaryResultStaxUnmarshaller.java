package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteUserPermissionsBoundaryResultStaxUnmarshaller
  implements Unmarshaller<DeleteUserPermissionsBoundaryResult, StaxUnmarshallerContext>
{
  private static DeleteUserPermissionsBoundaryResultStaxUnmarshaller instance;
  
  public DeleteUserPermissionsBoundaryResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteUserPermissionsBoundaryResult deleteUserPermissionsBoundaryResult = new DeleteUserPermissionsBoundaryResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteUserPermissionsBoundaryResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteUserPermissionsBoundaryResult;
        }
      }
    }
  }
  
  public static DeleteUserPermissionsBoundaryResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteUserPermissionsBoundaryResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteUserPermissionsBoundaryResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */