package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.ReceiveMessageResult;
import javax.xml.stream.events.XMLEvent;

public class ReceiveMessageResultStaxUnmarshaller
  implements Unmarshaller<ReceiveMessageResult, StaxUnmarshallerContext>
{
  private static ReceiveMessageResultStaxUnmarshaller instance;
  
  public ReceiveMessageResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    ReceiveMessageResult receiveMessageResult = new ReceiveMessageResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return receiveMessageResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Message", targetDepth)) {
          receiveMessageResult.withMessages(new Message[] { MessageStaxUnmarshaller.getInstance().unmarshall(context) });
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return receiveMessageResult;
      }
    }
  }
  
  public static ReceiveMessageResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ReceiveMessageResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.ReceiveMessageResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */