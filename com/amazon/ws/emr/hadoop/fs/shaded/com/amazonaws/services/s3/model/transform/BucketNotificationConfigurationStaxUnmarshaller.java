package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.BucketNotificationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.NotificationConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.XmlUtils;
import java.io.InputStream;
import java.util.Map.Entry;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.events.XMLEvent;

public class BucketNotificationConfigurationStaxUnmarshaller
  implements Unmarshaller<BucketNotificationConfiguration, InputStream>
{
  private static final BucketNotificationConfigurationStaxUnmarshaller instance = new BucketNotificationConfigurationStaxUnmarshaller();
  
  public static BucketNotificationConfigurationStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  public BucketNotificationConfiguration unmarshall(InputStream inputStream)
    throws Exception
  {
    StaxUnmarshallerContext context = new StaxUnmarshallerContext(XmlUtils.getXmlInputFactory().createXMLEventReader(inputStream));
    int originalDepth = context.getCurrentDepth();
    int targetDepth = originalDepth + 1;
    if (context.isStartOfDocument()) {
      targetDepth++;
    }
    BucketNotificationConfiguration config = new BucketNotificationConfiguration();
    for (;;)
    {
      XMLEvent xmlEvent = context.nextEvent();
      if (xmlEvent.isEndDocument()) {
        return config;
      }
      if ((xmlEvent.isAttribute()) || (xmlEvent.isStartElement()))
      {
        if (context.testExpression("TopicConfiguration", targetDepth))
        {
          Map.Entry<String, NotificationConfiguration> entry = TopicConfigurationStaxUnmarshaller.getInstance().unmarshall(context);
          config.addConfiguration((String)entry.getKey(), (NotificationConfiguration)entry.getValue());
        }
        else if (context.testExpression("QueueConfiguration", targetDepth))
        {
          Map.Entry<String, NotificationConfiguration> entry = QueueConfigurationStaxUnmarshaller.getInstance().unmarshall(context);
          config.addConfiguration((String)entry.getKey(), (NotificationConfiguration)entry.getValue());
        }
        else if (context.testExpression("CloudFunctionConfiguration", targetDepth))
        {
          Map.Entry<String, NotificationConfiguration> entry = LambdaConfigurationStaxUnmarshaller.getInstance().unmarshall(context);
          config.addConfiguration((String)entry.getKey(), (NotificationConfiguration)entry.getValue());
        }
      }
      else if ((xmlEvent.isEndElement()) && 
        (context.getCurrentDepth() < originalDepth)) {
        return config;
      }
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.BucketNotificationConfigurationStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */