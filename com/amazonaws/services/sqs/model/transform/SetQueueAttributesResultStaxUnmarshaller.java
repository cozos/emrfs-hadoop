package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.SetQueueAttributesResult;
import javax.xml.stream.events.XMLEvent;

public class SetQueueAttributesResultStaxUnmarshaller
  implements Unmarshaller<SetQueueAttributesResult, StaxUnmarshallerContext>
{
  private static SetQueueAttributesResultStaxUnmarshaller instance;
  
  public SetQueueAttributesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SetQueueAttributesResult setQueueAttributesResult = new SetQueueAttributesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return setQueueAttributesResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return setQueueAttributesResult;
        }
      }
    }
  }
  
  public static SetQueueAttributesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SetQueueAttributesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SetQueueAttributesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */