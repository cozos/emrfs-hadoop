package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.ListQueuesResult;
import javax.xml.stream.events.XMLEvent;

public class ListQueuesResultStaxUnmarshaller
  implements Unmarshaller<ListQueuesResult, StaxUnmarshallerContext>
{
  private static ListQueuesResultStaxUnmarshaller instance;
  
  public ListQueuesResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ListQueuesResult listQueuesResult = new ListQueuesResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return listQueuesResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("QueueUrl", targetDepth)) {
          listQueuesResult.withQueueUrls(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return listQueuesResult;
      }
    }
  }
  
  public static ListQueuesResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListQueuesResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ListQueuesResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */