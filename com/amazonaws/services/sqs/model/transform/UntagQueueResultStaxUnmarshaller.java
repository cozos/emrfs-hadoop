package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.UntagQueueResult;
import javax.xml.stream.events.XMLEvent;

public class UntagQueueResultStaxUnmarshaller
  implements Unmarshaller<UntagQueueResult, StaxUnmarshallerContext>
{
  private static UntagQueueResultStaxUnmarshaller instance;
  
  public UntagQueueResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    UntagQueueResult untagQueueResult = new UntagQueueResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return untagQueueResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return untagQueueResult;
        }
      }
    }
  }
  
  public static UntagQueueResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UntagQueueResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.UntagQueueResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */