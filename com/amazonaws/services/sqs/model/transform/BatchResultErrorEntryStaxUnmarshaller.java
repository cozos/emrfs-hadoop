package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.BatchResultErrorEntry;
import javax.xml.stream.events.XMLEvent;

public class BatchResultErrorEntryStaxUnmarshaller
  implements Unmarshaller<BatchResultErrorEntry, StaxUnmarshallerContext>
{
  private static BatchResultErrorEntryStaxUnmarshaller instance;
  
  public BatchResultErrorEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    BatchResultErrorEntry batchResultErrorEntry = new BatchResultErrorEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return batchResultErrorEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth)) {
          batchResultErrorEntry.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("SenderFault", targetDepth)) {
          batchResultErrorEntry.setSenderFault(SimpleTypeStaxUnmarshallers.BooleanStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Code", targetDepth)) {
          batchResultErrorEntry.setCode(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("Message", targetDepth)) {
          batchResultErrorEntry.setMessage(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return batchResultErrorEntry;
      }
    }
  }
  
  public static BatchResultErrorEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BatchResultErrorEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.BatchResultErrorEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */