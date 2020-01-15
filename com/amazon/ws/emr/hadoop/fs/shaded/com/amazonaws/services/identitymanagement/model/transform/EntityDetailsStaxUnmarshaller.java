package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EntityDetails;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class EntityDetailsStaxUnmarshaller
  implements Unmarshaller<EntityDetails, StaxUnmarshallerContext>
{
  private static EntityDetailsStaxUnmarshaller instance;
  
  public EntityDetails unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    EntityDetails entityDetails = new EntityDetails();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return entityDetails;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("EntityInfo", targetDepth)) {
          entityDetails.setEntityInfo(EntityInfoStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("LastAuthenticated", targetDepth)) {
          entityDetails.setLastAuthenticated(SimpleTypeStaxUnmarshallers.DateStaxUnmarshallerFactory.getInstance("iso8601").unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return entityDetails;
      }
    }
  }
  
  public static EntityDetailsStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EntityDetailsStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.EntityDetailsStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */