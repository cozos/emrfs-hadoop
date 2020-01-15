package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.Message;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

public class MessageStaxUnmarshaller
  implements Unmarshaller<Message, StaxUnmarshallerContext>
{
  private static MessageStaxUnmarshaller instance;
  
  private static class AttributesMapEntryUnmarshaller
    implements Unmarshaller<Map.Entry<String, String>, StaxUnmarshallerContext>
  {
    private static AttributesMapEntryUnmarshaller instance;
    
    public Map.Entry<String, String> unmarshall(StaxUnmarshallerContext context)
      throws Exception
    {
      int originalDepth = context.getCurrentDepth();
      int targetDepth = originalDepth + 1;
      
      MapEntry<String, String> entry = new MapEntry();
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
            entry.setValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
        else if ((xmlEvent.isEndElement()) && 
          (context.getCurrentDepth() < originalDepth)) {
          return entry;
        }
      }
    }
    
    public static AttributesMapEntryUnmarshaller getInstance()
    {
      if (instance == null) {
        instance = new AttributesMapEntryUnmarshaller();
      }
      return instance;
    }
  }
  
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
  
  public Message unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    Message message = new Message();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return message;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("MessageId", targetDepth))
        {
          message.setMessageId(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("ReceiptHandle", targetDepth))
        {
          message.setReceiptHandle(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("MD5OfBody", targetDepth))
        {
          message.setMD5OfBody(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("Body", targetDepth))
        {
          message.setBody(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("Attribute", targetDepth))
        {
          Map.Entry<String, String> entry = AttributesMapEntryUnmarshaller.getInstance().unmarshall(context);
          message.addAttributesEntry((String)entry.getKey(), (String)entry.getValue());
        }
        else if (context.testExpression("MD5OfMessageAttributes", targetDepth))
        {
          message.setMD5OfMessageAttributes(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
        else if (context.testExpression("MessageAttribute", targetDepth))
        {
          Map.Entry<String, MessageAttributeValue> entry = MessageAttributesMapEntryUnmarshaller.getInstance().unmarshall(context);
          message.addMessageAttributesEntry((String)entry.getKey(), (MessageAttributeValue)entry.getValue());
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return message;
      }
    }
  }
  
  public static MessageStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MessageStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.MessageStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */