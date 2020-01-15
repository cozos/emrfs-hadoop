package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class DeleteRolePolicyResultStaxUnmarshaller
  implements Unmarshaller<DeleteRolePolicyResult, StaxUnmarshallerContext>
{
  private static DeleteRolePolicyResultStaxUnmarshaller instance;
  
  public DeleteRolePolicyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteRolePolicyResult deleteRolePolicyResult = new DeleteRolePolicyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteRolePolicyResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteRolePolicyResult;
        }
      }
    }
  }
  
  public static DeleteRolePolicyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteRolePolicyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.DeleteRolePolicyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */