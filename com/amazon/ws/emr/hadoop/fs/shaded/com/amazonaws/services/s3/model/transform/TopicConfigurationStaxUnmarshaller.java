package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.TopicConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.StaxUnmarshallerContext;

class TopicConfigurationStaxUnmarshaller
  extends NotificationConfigurationStaxUnmarshaller<TopicConfiguration>
{
  private static final TopicConfigurationStaxUnmarshaller instance = new TopicConfigurationStaxUnmarshaller();
  
  public static TopicConfigurationStaxUnmarshaller getInstance()
  {
    return instance;
  }
  
  protected boolean handleXmlEvent(TopicConfiguration topicConfig, StaxUnmarshallerContext context, int targetDepth)
    throws Exception
  {
    if (context.testExpression("Topic", targetDepth))
    {
      topicConfig.setTopicARN(SimpleTypeStaxUnmarshallers.StringStaxUnmarshaller.getInstance().unmarshall(context));
      return true;
    }
    return false;
  }
  
  protected TopicConfiguration createConfiguration()
  {
    return new TopicConfiguration();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.transform.TopicConfigurationStaxUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */