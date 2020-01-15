package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.ChangeMessageVisibilityBatchResultEntry;
import javax.xml.stream.events.XMLEvent;

public class ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller
  implements Unmarshaller<ChangeMessageVisibilityBatchResultEntry, StaxUnmarshallerContext>
{
  private static ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller instance;
  
  public ChangeMessageVisibilityBatchResultEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ChangeMessageVisibilityBatchResultEntry changeMessageVisibilityBatchResultEntry = new ChangeMessageVisibilityBatchResultEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return changeMessageVisibilityBatchResultEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          changeMessageVisibilityBatchResultEntry.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return changeMessageVisibilityBatchResultEntry;
      }
    }
  }
  
  public static ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ChangeMessageVisibilityBatchResultEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */