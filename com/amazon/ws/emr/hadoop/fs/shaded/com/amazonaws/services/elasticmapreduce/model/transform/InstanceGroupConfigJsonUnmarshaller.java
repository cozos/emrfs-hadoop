package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceGroupConfigJsonUnmarshaller
  implements Unmarshaller<InstanceGroupConfig, JsonUnmarshallerContext>
{
  private static InstanceGroupConfigJsonUnmarshaller instance;
  
  public InstanceGroupConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceGroupConfig instanceGroupConfig = new InstanceGroupConfig();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return null;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Market", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setMarket((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceRole", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setInstanceRole((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BidPrice", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setBidPrice((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceType", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceCount", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setInstanceCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("Configurations", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setConfigurations(new ListUnmarshaller(ConfigurationJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("EbsConfiguration", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setEbsConfiguration(EbsConfigurationJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("AutoScalingPolicy", targetDepth))
        {
          context.nextToken();
          instanceGroupConfig.setAutoScalingPolicy(AutoScalingPolicyJsonUnmarshaller.getInstance().unmarshall(context));
        }
      }
      else
      {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return instanceGroupConfig;
  }
  
  public static InstanceGroupConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceGroupConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */