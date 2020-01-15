package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.DeleteMessageResult;
import javax.xml.stream.events.XMLEvent;

public class DeleteMessageResultStaxUnmarshaller
  implements Unmarshaller<DeleteMessageResult, StaxUnmarshallerContext>
{
  private static DeleteMessageResultStaxUnmarshaller instance;
  
  public DeleteMessageResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteMessageResult deleteMessageResult = new DeleteMessageResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteMessageResult;
      }
      if ((!xmlEvent.isAttribute()) && (!xmlEvent.isStartElement())) {
        if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return deleteMessageResult;
        }
      }
    }
  }
  
  public static DeleteMessageResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteMessageResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteMessageResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */