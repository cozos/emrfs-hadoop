package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.MessageSystemAttributeValue;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

class SendMessageBatchRequestEntryStaxUnmarshaller$MessageSystemAttributesMapEntryUnmarshaller
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

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.SendMessageBatchRequestEntryStaxUnmarshaller.MessageSystemAttributesMapEntryUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */