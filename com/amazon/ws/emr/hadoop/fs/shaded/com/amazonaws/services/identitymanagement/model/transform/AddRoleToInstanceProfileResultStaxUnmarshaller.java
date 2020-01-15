package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AddRoleToInstanceProfileResultStaxUnmarshaller
  implements Unmarshaller<AddRoleToInstanceProfileResult, StaxUnmarshallerContext>
{
  private static AddRoleToInstanceProfileResultStaxUnmarshaller instance;
  
  public AddRoleToInstanceProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AddRoleToInstanceProfileResult addRoleToInstanceProfileResult = new AddRoleToInstanceProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return addRoleToInstanceProfileResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return addRoleToInstanceProfileResult;
        }
      }
    }
  }
  
  public static AddRoleToInstanceProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddRoleToInstanceProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddRoleToInstanceProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */