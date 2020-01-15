package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.SendMessageResult;
import javax.xml.stream.events.XMLEvent;

public class SendMessageResultStaxUnmarshaller
  implements Unmarshaller<SendMessageResult, StaxUnmarshallerContext>
{
  private static SendMessageResultStaxUnmarshaller instance;
  
  public SendMessageResult unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SendMessageResult sendMessageResult = new SendMessageResult();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth += 2;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return sendMessageResult;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MD5OfMessageBody", targetDepth)) {
          sendMessageResult.setMD5OfMessageBody(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MD5OfMessageAttributes", targetDepth)) {
          sendMessageResult.setMD5OfMessageAttributes(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MD5OfMessageSystemAttributes", targetDepth)) {
          sendMessageResult.setMD5OfMessageSystemAttributes(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("MessageId", targetDepth)) {
          sendMessageResult.setMessageId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("SequenceNumber", targetDepth)) {
          sendMessageResult.setSequenceNumber(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return sendMessageResult;
      }
    }
  }
  
  public static SendMessageResultStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SendMessageResultStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SendMessageResultStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */