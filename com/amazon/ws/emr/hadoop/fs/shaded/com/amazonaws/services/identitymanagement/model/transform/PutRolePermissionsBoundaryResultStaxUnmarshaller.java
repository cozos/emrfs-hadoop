package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class PutRolePermissionsBoundaryResultStaxUnmarshaller
  implements Unmarshaller<PutRolePermissionsBoundaryResult, StaxUnmarshallerContext>
{
  private static PutRolePermissionsBoundaryResultStaxUnmarshaller instance;
  
  public PutRolePermissionsBoundaryResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PutRolePermissionsBoundaryResult putRolePermissionsBoundaryResult = new PutRolePermissionsBoundaryResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return putRolePermissionsBoundaryResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return putRolePermissionsBoundaryResult;
        }
      }
    }
  }
  
  public static PutRolePermissionsBoundaryResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutRolePermissionsBoundaryResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutRolePermissionsBoundaryResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */