package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.PurgeQueueResult;
import javax.xml.stream.events.XMLEvent;

public class PurgeQueueResultStaxUnmarshaller
  implements Unmarshaller<PurgeQueueResult, StaxUnmarshallerContext>
{
  private static PurgeQueueResultStaxUnmarshaller instance;
  
  public PurgeQueueResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    PurgeQueueResult purgeQueueResult = new PurgeQueueResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return purgeQueueResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return purgeQueueResult;
        }
      }
    }
  }
  
  public static PurgeQueueResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PurgeQueueResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.PurgeQueueResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */