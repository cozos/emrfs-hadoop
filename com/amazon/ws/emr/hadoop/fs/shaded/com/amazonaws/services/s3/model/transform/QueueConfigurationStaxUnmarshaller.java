package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.QueueConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;

class QueueConfigurationStaxUnmarshaller
  extends NotificationConfigurationStaxUnmarshaller<QueueConfiguration>
{
  private static final QueueConfigurationStaxUnmarshaller instance = new QueueConfigurationStaxUnmarshaller();
  
  public static QueueConfigurationStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  protected boolean handleXmlEvent(QueueConfiguration queueConfig, StaxUnmarshallerContext context, int targetDepth)
    throws Exception
  {
    if (context.testExpression("Queue", targetDepth))
    {
      queueConfig.setQueueARN(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
      return true;
    }
    return false;
  }
  
  protected QueueConfiguration createConfiguration()
  {
    return new QueueConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.QueueConfigurationStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */