package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResult;
import com.amazonaws.services.sqs.model.DeleteMessageBatchResultEntry;
import javax.xml.stream.events.XMLEvent;

public class DeleteMessageBatchResultStaxUnmarshaller
  implements Unmarshaller<DeleteMessageBatchResult, StaxUnmarshallerContext>
{
  private static DeleteMessageBatchResultStaxUnmarshaller instance;
  
  public DeleteMessageBatchResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    DeleteMessageBatchResult deleteMessageBatchResult = new DeleteMessageBatchResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return deleteMessageBatchResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("DeleteMessageBatchResultEntry", targetDepth)) {
          deleteMessageBatchResult.withSuccessful(new DeleteMessageBatchResultEntry[] { DeleteMessageBatchResultEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("BatchResultErrorEntry", targetDepth)) {
          deleteMessageBatchResult.withFailed(new BatchResultErrorEntry[] { BatchResultErrorEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return deleteMessageBatchResult;
      }
    }
  }
  
  public static DeleteMessageBatchResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteMessageBatchResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.DeleteMessageBatchResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */