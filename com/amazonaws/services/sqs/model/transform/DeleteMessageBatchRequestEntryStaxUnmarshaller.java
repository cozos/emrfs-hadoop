package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.DeleteMessageBatchRequestEntry;
import javax.xml.stream.events.XMLEvent;

public class DeleteMessageBatchRequestEntryStaxUnmarshaller
  implements Unmarshaller<DeleteMessageBatchRequestEntry, StaxUnmarshallerContext>
{
  private static DeleteMessageBatchRequestEntryStaxUnmarshaller instance;
  
  public DeleteMessageBatchRequestEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteMessageBatchRequestEntry deleteMessageBatchRequestEntry = new DeleteMessageBatchRequestEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteMessageBatchRequestEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          deleteMessageBatchRequestEntry.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ReceiptHandle", targetDepth)) {
          deleteMessageBatchRequestEntry.setReceiptHandle(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return deleteMessageBatchRequestEntry;
      }
    }
  }
  
  public static DeleteMessageBatchRequestEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteMessageBatchRequestEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteMessageBatchRequestEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */