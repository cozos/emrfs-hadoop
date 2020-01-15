package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.CreateQueueResult;
import javax.xml.stream.events.XMLEvent;

public class CreateQueueResultStaxUnmarshaller
  implements Unmarshaller<CreateQueueResult, StaxUnmarshallerContext>
{
  private static CreateQueueResultStaxUnmarshaller instance;
  
  public CreateQueueResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    CreateQueueResult createQueueResult = new CreateQueueResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return createQueueResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("QueueUrl", targetDepth)) {
          createQueueResult.setQueueUrl(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return createQueueResult;
      }
    }
  }
  
  public static CreateQueueResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateQueueResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.CreateQueueResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */