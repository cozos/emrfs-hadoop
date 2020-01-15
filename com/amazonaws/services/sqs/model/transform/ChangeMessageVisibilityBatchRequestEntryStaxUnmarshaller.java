package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchRequestEntry;
import javax.xml.stream.events.XMLEvent;

public class ChangeMessageVisibilityBatchRequestEntryStaxUnmarshaller
  implements Unmarshaller<ChangeMessageVisibilityBatchRequestEntry, StaxUnmarshallerContext>
{
  private static ChangeMessageVisibilityBatchRequestEntryStaxUnmarshaller instance;
  
  public ChangeMessageVisibilityBatchRequestEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ChangeMessageVisibilityBatchRequestEntry changeMessageVisibilityBatchRequestEntry = new ChangeMessageVisibilityBatchRequestEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return changeMessageVisibilityBatchRequestEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          changeMessageVisibilityBatchRequestEntry.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("ReceiptHandle", targetDepth)) {
          changeMessageVisibilityBatchRequestEntry.setReceiptHandle(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("VisibilityTimeout", targetDepth)) {
          changeMessageVisibilityBatchRequestEntry.setVisibilityTimeout(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return changeMessageVisibilityBatchRequestEntry;
      }
    }
  }
  
  public static ChangeMessageVisibilityBatchRequestEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ChangeMessageVisibilityBatchRequestEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchRequestEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */