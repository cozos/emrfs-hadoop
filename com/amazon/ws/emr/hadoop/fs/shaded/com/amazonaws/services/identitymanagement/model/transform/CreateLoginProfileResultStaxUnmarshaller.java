package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateLoginProfileResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateLoginProfileResultStaxUnmarshaller
  implements Unmarshaller<CreateLoginProfileResult, StaxUnmarshallerContext>
{
  private static CreateLoginProfileResultStaxUnmarshaller instance;
  
  public CreateLoginProfileResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateLoginProfileResult createLoginProfileResult = new CreateLoginProfileResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createLoginProfileResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("LoginProfile", targetDepth)) {
          createLoginProfileResult.setLoginProfile(LoginProfileStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createLoginProfileResult;
      }
    }
  }
  
  public static CreateLoginProfileResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateLoginProfileResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateLoginProfileResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */