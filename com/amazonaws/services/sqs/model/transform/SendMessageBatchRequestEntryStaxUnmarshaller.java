package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import com.amazonaws.services.sqs.model.MessageSystemAttributeValue;
import com.amazonaws.services.sqs.model.SendMessageBatchRequestEntry;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class SendMessageBatchRequestEntryStaxUnmarshaller
  implements Unmarshaller<SendMessageBatchRequestEntry, StaxUnmarshallerContext>
{
  private static SendMessageBatchRequestEntryStaxUnmarshaller instance;
  
  private static class MessageAttributesMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, MessageAttributeValue>, StaxUnmarshallerContext>
  {
    private static MessageAttributesMapEntryUnmarshaller instance;
    
    public Map.Entry<String, MessageAttributeValue> unmarshall(StaxUnmarshallerContext context)
      throws Exception
    {
      int originalDepth = context.getCurrentDepth();
      int targetDepth = originalDepth + 1;
      
      MapEntry<String, MessageAttributeValue> entry = new MapEntry();
      for (;;)
      {
        XMLEvent xmlEvent = context.nextEvent();
        if (xmlEvent.isEndDocument()) {
          return entry;
        }
        if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
        {
          if (context.testExpression("Name", targetDepth)) {
            entry.setKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          } else if (context.testExpression("Value", targetDepth)) {
            entry.setValue(MessageAttributeValueStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
        else if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return entry;
        }
      }
    }
    
    public static MessageAttributesMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new MessageAttributesMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
  private static class MessageSystemAttributesMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, MessageSystemAttributeValue>, StaxUnmarshallerContext>
  {
    private static MessageSystemAttributesMapEntryUnmarshaller instance;
    
    public Map.Entry<String, MessageSystemAttributeValue> unmarshall(StaxUnmarshallerContext context)
      throws Exception
    {
      int originalDepth = context.getCurrentDepth();
      int targetDepth = originalDepth + 1;
      
      MapEntry<String, MessageSystemAttributeValue> entry = new MapEntry();
      for (;;)
      {
        XMLEvent xmlEvent = context.nextEvent();
        if (xmlEvent.isEndDocument()) {
          return entry;
        }
        if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
        {
          if (context.testExpression("Name", targetDepth)) {
            entry.setKey(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          } else if (context.testExpression("Value", targetDepth)) {
            entry.setValue(MessageSystemAttributeValueStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
        else if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return entry;
        }
      }
    }
    
    public static MessageSystemAttributesMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new MessageSystemAttributesMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
  public SendMessageBatchRequestEntry unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    SendMessageBatchRequestEntry sendMessageBatchRequestEntry = new SendMessageBatchRequestEntry();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return sendMessageBatchRequestEntry;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("Id", targetDepth))
        {
          sendMessageBatchRequestEntry.setId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("MessageBody", targetDepth))
        {
          sendMessageBatchRequestEntry.setMessageBody(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("DelaySeconds", targetDepth))
        {
          sendMessageBatchRequestEntry.setDelaySeconds(SimpleTypeStaxUnmarshallers.IntegerStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("MessageAttribute", targetDepth))
        {
          Map.Entry<String, MessageAttributeValue> entry = MessageAttributesMapEntryUnmarshaller.getInstance().unmarshall(context);
          sendMessageBatchRequestEntry.addMessageAttributesEntry((String)entry.getKey(), (MessageAttributeValue)entry.getValue());
        }
        else if (context.testExpression("MessageSystemAttribute", targetDepth))
        {
          Map.Entry<String, MessageSystemAttributeValue> entry = MessageSystemAttributesMapEntryUnmarshaller.getInstance().unmarshall(context);
          sendMessageBatchRequestEntry.addMessageSystemAttributesEntry((String)entry.getKey(), (MessageSystemAttributeValue)entry.getValue());
        }
        else if (context.testExpression("MessageDeduplicationId", targetDepth))
        {
          sendMessageBatchRequestEntry.setMessageDeduplicationId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("MessageGroupId", targetDepth))
        {
          sendMessageBatchRequestEntry.setMessageGroupId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return sendMessageBatchRequestEntry;
      }
    }
  }
  
  public static SendMessageBatchRequestEntryStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SendMessageBatchRequestEntryStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SendMessageBatchRequestEntryStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */