package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachedPermissionsBoundary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AttachedPermissionsBoundaryStaxUnmarshaller
  implements Unmarshaller<AttachedPermissionsBoundary, StaxUnmarshallerContext>
{
  private static AttachedPermissionsBoundaryStaxUnmarshaller instance;
  
  public AttachedPermissionsBoundary unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AttachedPermissionsBoundary attachedPermissionsBoundary = new AttachedPermissionsBoundary();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return attachedPermissionsBoundary;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("PermissionsBoundaryType", targetDepth)) {
          attachedPermissionsBoundary.setPermissionsBoundaryType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("PermissionsBoundaryArn", targetDepth)) {
          attachedPermissionsBoundary.setPermissionsBoundaryArn(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return attachedPermissionsBoundary;
      }
    }
  }
  
  public static AttachedPermissionsBoundaryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AttachedPermissionsBoundaryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AttachedPermissionsBoundaryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */