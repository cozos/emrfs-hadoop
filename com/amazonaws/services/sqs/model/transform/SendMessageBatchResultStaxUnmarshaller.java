package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.SendMessageBatchResult;
import com.amazonaws.services.sqs.model.SendMessageBatchResultEntry;
import javax.xml.stream.events.XMLEvent;

public class SendMessageBatchResultStaxUnmarshaller
  implements Unmarshaller<SendMessageBatchResult, StaxUnmarshallerContext>
{
  private static SendMessageBatchResultStaxUnmarshaller instance;
  
  public SendMessageBatchResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SendMessageBatchResult sendMessageBatchResult = new SendMessageBatchResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return sendMessageBatchResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("SendMessageBatchResultEntry", targetDepth)) {
          sendMessageBatchResult.withSuccessful(new SendMessageBatchResultEntry[] { SendMessageBatchResultEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("BatchResultErrorEntry", targetDepth)) {
          sendMessageBatchResult.withFailed(new BatchResultErrorEntry[] { BatchResultErrorEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return sendMessageBatchResult;
      }
    }
  }
  
  public static SendMessageBatchResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SendMessageBatchResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SendMessageBatchResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */