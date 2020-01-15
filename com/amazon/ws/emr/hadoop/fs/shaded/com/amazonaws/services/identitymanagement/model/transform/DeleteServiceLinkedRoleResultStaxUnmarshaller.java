package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceLinkedRoleResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteServiceLinkedRoleResultStaxUnmarshaller
  implements Unmarshaller<DeleteServiceLinkedRoleResult, StaxUnmarshallerContext>
{
  private static DeleteServiceLinkedRoleResultStaxUnmarshaller instance;
  
  public DeleteServiceLinkedRoleResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteServiceLinkedRoleResult deleteServiceLinkedRoleResult = new DeleteServiceLinkedRoleResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteServiceLinkedRoleResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("DeletionTaskId", targetDepth)) {
          deleteServiceLinkedRoleResult.setDeletionTaskId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return deleteServiceLinkedRoleResult;
      }
    }
  }
  
  public static DeleteServiceLinkedRoleResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteServiceLinkedRoleResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteServiceLinkedRoleResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */