package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResult;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResultEntry;
import javax.xml.stream.events.XMLEvent;

public class ChangeMessageVisibilityBatchResultStaxUnmarshaller
  implements Unmarshaller<ChangeMessageVisibilityBatchResult, StaxUnmarshallerContext>
{
  private static ChangeMessageVisibilityBatchResultStaxUnmarshaller instance;
  
  public ChangeMessageVisibilityBatchResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ChangeMessageVisibilityBatchResult changeMessageVisibilityBatchResult = new ChangeMessageVisibilityBatchResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return changeMessageVisibilityBatchResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("ChangeMessageVisibilityBatchResultEntry", targetDepth)) {
          changeMessageVisibilityBatchResult.withSuccessful(new ChangeMessageVisibilityBatchResultEntry[] { ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("BatchResultErrorEntry", targetDepth)) {
          changeMessageVisibilityBatchResult.withFailed(new BatchResultErrorEntry[] { BatchResultErrorEntryStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return changeMessageVisibilityBatchResult;
      }
    }
  }
  
  public static ChangeMessageVisibilityBatchResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ChangeMessageVisibilityBatchResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */