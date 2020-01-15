package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccessKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import javax.xml.stream.events.XMLEvent;

public class CreateAccessKeyResultStaxUnmarshaller
  implements Unmarshaller<CreateAccessKeyResult, StaxUnmarshallerContext>
{
  private static CreateAccessKeyResultStaxUnmarshaller instance;
  
  public CreateAccessKeyResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateAccessKeyResult createAccessKeyResult = new CreateAccessKeyResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createAccessKeyResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("AccessKey", targetDepth)) {
          createAccessKeyResult.setAccessKey(AccessKeyStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createAccessKeyResult;
      }
    }
  }
  
  public static CreateAccessKeyResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateAccessKeyResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.transform.CreateAccessKeyResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */