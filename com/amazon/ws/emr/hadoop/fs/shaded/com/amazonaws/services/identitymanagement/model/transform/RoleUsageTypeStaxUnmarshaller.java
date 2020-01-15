package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RoleUsageType;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.ArrayList;
import javax.xml.stream.events.XMLEvent;

public class RoleUsageTypeStaxUnmarshaller
  implements Unmarshaller<RoleUsageType, StaxUnmarshallerContext>
{
  private static RoleUsageTypeStaxUnmarshaller instance;
  
  public RoleUsageType unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    RoleUsageType roleUsageType = new RoleUsageType();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return roleUsageType;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Region", targetDepth)) {
          roleUsageType.setRegion(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Resources", targetDepth)) {
          roleUsageType.withResources(new ArrayList());
        } else if (context.testExpression("Resources/member", targetDepth)) {
          roleUsageType.withResources(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return roleUsageType;
      }
    }
  }
  
  public static RoleUsageTypeStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RoleUsageTypeStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.RoleUsageTypeStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */