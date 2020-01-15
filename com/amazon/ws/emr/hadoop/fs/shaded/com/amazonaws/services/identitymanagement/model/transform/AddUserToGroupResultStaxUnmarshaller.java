package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class AddUserToGroupResultStaxUnmarshaller
  implements Unmarshaller<AddUserToGroupResult, StaxUnmarshallerContext>
{
  private static AddUserToGroupResultStaxUnmarshaller instance;
  
  public AddUserToGroupResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    AddUserToGroupResult addUserToGroupResult = new AddUserToGroupResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return addUserToGroupResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return addUserToGroupResult;
        }
      }
    }
  }
  
  public static AddUserToGroupResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddUserToGroupResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.AddUserToGroupResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */