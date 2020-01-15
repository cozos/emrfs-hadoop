package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.TagQueueResult;
import javax.xml.stream.events.XMLEvent;

public class TagQueueResultStaxUnmarshaller
  implements Unmarshaller<TagQueueResult, StaxUnmarshallerContext>
{
  private static TagQueueResultStaxUnmarshaller instance;
  
  public TagQueueResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    TagQueueResult tagQueueResult = new TagQueueResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return tagQueueResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return tagQueueResult;
        }
      }
    }
  }
  
  public static TagQueueResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TagQueueResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.TagQueueResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */