package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import java.util.AbstractMap.SimpleEntry;
import java.util.Map.Entry;
import javax.xml.stream.events.XMLEvent;

abstract class NotificationConfigurationStaxUnmarshaller<T extends NotificationConfiguration>
  implements Unmarshaller<Map.Entry<String, NotificationConfiguration>, StaxUnmarshallerContext>
{
  public Map.Entry<String, NotificationConfiguration> unmarshall(StaxUnmarshallerContext context)
    throws Exception
  {
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    T topicConfig = createConfiguration();
    String id = null;
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return new AbstractMap.SimpleEntry(id, topicConfig);
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (!handleXmlEvent(topicConfig, context, targetDepth)) {
          if (context.testExpression("Id", targetDepth)) {
            id = SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context);
          } else if (context.testExpression("Event", targetDepth)) {
            topicConfig.addEvent(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
          } else if (context.testExpression("Filter", targetDepth)) {
            topicConfig.setFilter(FilterStaxUnmarshaller.getInstance().unmarshall(context));
          }
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return new AbstractMap.SimpleEntry(id, topicConfig);
      }
    }
  }
  
  protected abstract T createConfiguration();
  
  protected abstract boolean handleXmlEvent(T paramT, StaxUnmarshallerContext paramStaxUnmarshallerContext, int paramInt)
    throws Exception;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.NotificationConfigurationStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */