package com.amazonaws.services.sqs.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazonaws.services.sqs.model.MessageSystemAttributeValue;
import java.nio.ByteBuffer;
import javax.xml.stream.events.XMLEvent;

public class MessageSystemAttributeValueStaxUnmarshaller
  implements Unmarshaller<MessageSystemAttributeValue, StaxUnmarshallerContext>
{
  private static MessageSystemAttributeValueStaxUnmarshaller instance;
  
  public MessageSystemAttributeValue unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    MessageSystemAttributeValue messageSystemAttributeValue = new MessageSystemAttributeValue();
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return messageSystemAttributeValue;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("StringValue", targetDepth)) {
          messageSystemAttributeValue.setStringValue(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("BinaryValue", targetDepth)) {
          messageSystemAttributeValue.setBinaryValue(SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context));
        } else if (context.testExpression("StringListValue", targetDepth)) {
          messageSystemAttributeValue.withStringListValues(new String[] { SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("BinaryListValue", targetDepth)) {
          messageSystemAttributeValue.withBinaryListValues(new ByteBuffer[] { SimpleTypeStaxUnmarshallers.ByteBufferStaxUnmarshaller.getInstance().unmarshall(context) });
        } else if (context.testExpression("DataType", targetDepth)) {
          messageSystemAttributeValue.setDataType(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return messageSystemAttributeValue;
      }
    }
  }
  
  public static MessageSystemAttributeValueStaxUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new MessageSystemAttributeValueStaxUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.model.transform.MessageSystemAttributeValueStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */