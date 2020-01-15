package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.MessageAttributeValue;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

class SendMessageBatchRequestEntryStaxUnmarshaller$MessageAttributesMapEntryUnmarshaller
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

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SendMessageBatchRequestEntryStaxUnmarshaller.MessageAttributesMapEntryUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */