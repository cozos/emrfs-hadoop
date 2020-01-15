package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPermissionsBoundaryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class PutUserPermissionsBoundaryResultStaxUnmarshaller
  implements Unmarshaller<PutUserPermissionsBoundaryResult, StaxUnmarshallerContext>
{
  private static PutUserPermissionsBoundaryResultStaxUnmarshaller instance;
  
  public PutUserPermissionsBoundaryResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PutUserPermissionsBoundaryResult putUserPermissionsBoundaryResult = new PutUserPermissionsBoundaryResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return putUserPermissionsBoundaryResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return putUserPermissionsBoundaryResult;
        }
      }
    }
  }
  
  public static PutUserPermissionsBoundaryResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutUserPermissionsBoundaryResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.PutUserPermissionsBoundaryResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */