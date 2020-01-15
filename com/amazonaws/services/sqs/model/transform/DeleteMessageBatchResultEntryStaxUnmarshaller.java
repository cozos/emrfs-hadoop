package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResultEntry;
import javax.xml.stream.events.XMLEvent;

public class DeleteMessageBatchResultEntryStaxUnmarshaller
  implements Unmarshaller<DeleteMessageBatchResultEntry, StaxUnmarshallerContext>
{
  private static DeleteMessageBatchResultEntryStaxUnmarshaller instance;
  
  public DeleteMessageBatchResultEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteMessageBatchResultEntry deleteMessageBatchResultEntry = new DeleteMessageBatchResultEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteMessageBatchResultEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          deleteMessageBatchResultEntry.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return deleteMessageBatchResultEntry;
      }
    }
  }
  
  public static DeleteMessageBatchResultEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteMessageBatchResultEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteMessageBatchResultEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */