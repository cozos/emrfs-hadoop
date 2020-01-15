package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.SendMessageBatchResultEntry;
import javax.xml.stream.events.XMLEvent;

public class SendMessageBatchResultEntryStaxUnmarshaller
  implements Unmarshaller<SendMessageBatchResultEntry, StaxUnmarshallerContext>
{
  private static SendMessageBatchResultEntryStaxUnmarshaller instance;
  
  public SendMessageBatchResultEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SendMessageBatchResultEntry sendMessageBatchResultEntry = new SendMessageBatchResultEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return sendMessageBatchResultEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          sendMessageBatchResultEntry.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MessageId", targetDepth)) {
          sendMessageBatchResultEntry.setMessageId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MD5OfMessageBody", targetDepth)) {
          sendMessageBatchResultEntry.setMD5OfMessageBody(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MD5OfMessageAttributes", targetDepth)) {
          sendMessageBatchResultEntry.setMD5OfMessageAttributes(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MD5OfMessageSystemAttributes", targetDepth)) {
          sendMessageBatchResultEntry.setMD5OfMessageSystemAttributes(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("SequenceNumber", targetDepth)) {
          sendMessageBatchResultEntry.setSequenceNumber(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return sendMessageBatchResultEntry;
      }
    }
  }
  
  public static SendMessageBatchResultEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SendMessageBatchResultEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SendMessageBatchResultEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */