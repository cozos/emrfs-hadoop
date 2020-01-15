package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.ListDeadLetterSourceQueuesResult;
import javax.xml.stream.events.XMLEvent;

public class ListDeadLetterSourceQueuesResultStaxUnmarshaller
  implements Unmarshaller<ListDeadLetterSourceQueuesResult, StaxUnmarshallerContext>
{
  private static ListDeadLetterSourceQueuesResultStaxUnmarshaller instance;
  
  public ListDeadLetterSourceQueuesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListDeadLetterSourceQueuesResult listDeadLetterSourceQueuesResult = new ListDeadLetterSourceQueuesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listDeadLetterSourceQueuesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("QueueUrl", targetDepth)) {
          listDeadLetterSourceQueuesResult.withQueueUrls(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listDeadLetterSourceQueuesResult;
      }
    }
  }
  
  public static ListDeadLetterSourceQueuesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListDeadLetterSourceQueuesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ListDeadLetterSourceQueuesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */