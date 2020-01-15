package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.DeleteQueueResult;
import javax.xml.stream.events.XMLEvent;

public class DeleteQueueResultStaxUnmarshaller
  implements Unmarshaller<DeleteQueueResult, StaxUnmarshallerContext>
{
  private static DeleteQueueResultStaxUnmarshaller instance;
  
  public DeleteQueueResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteQueueResult deleteQueueResult = new DeleteQueueResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteQueueResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteQueueResult;
        }
      }
    }
  }
  
  public static DeleteQueueResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteQueueResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteQueueResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */