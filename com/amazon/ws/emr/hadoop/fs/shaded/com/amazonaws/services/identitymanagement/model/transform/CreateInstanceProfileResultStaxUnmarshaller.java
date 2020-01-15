package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateInstanceProfileResultStaxUnmarshaller
  implements Unmarshaller<CreateInstanceProfileResult, StaxUnmarshallerContext>
{
  private static CreateInstanceProfileResultStaxUnmarshaller instance;
  
  public CreateInstanceProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateInstanceProfileResult createInstanceProfileResult = new CreateInstanceProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createInstanceProfileResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("InstanceProfile", targetDepth)) {
          createInstanceProfileResult.setInstanceProfile(InstanceProfileStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createInstanceProfileResult;
      }
    }
  }
  
  public static CreateInstanceProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateInstanceProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateInstanceProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */