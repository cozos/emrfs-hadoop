package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroup;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceGroupJsonUnmarshaller
  implements Unmarshaller<InstanceGroup, JsonUnmarshallerContext>
{
  private static InstanceGroupJsonUnmarshaller instance;
  
  public InstanceGroup unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceGroup instanceGroup = new InstanceGroup();
    
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
        if (context.testExpression("Id", targetDepth))
        {
          context.nextToken();
          instanceGroup.setId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          instanceGroup.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Market", targetDepth))
        {
          context.nextToken();
          instanceGroup.setMarket((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceGroupType", targetDepth))
        {
          context.nextToken();
          instanceGroup.setInstanceGroupType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BidPrice", targetDepth))
        {
          context.nextToken();
          instanceGroup.setBidPrice((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceType", targetDepth))
        {
          context.nextToken();
          instanceGroup.setInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("RequestedInstanceCount", targetDepth))
        {
          context.nextToken();
          instanceGroup.setRequestedInstanceCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("RunningInstanceCount", targetDepth))
        {
          context.nextToken();
          instanceGroup.setRunningInstanceCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("Status", targetDepth))
        {
          context.nextToken();
          instanceGroup.setStatus(InstanceGroupStatusJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Configurations", targetDepth))
        {
          context.nextToken();
          instanceGroup.setConfigurations(new ListUnmarshaller(ConfigurationJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ConfigurationsVersion", targetDepth))
        {
          context.nextToken();
          instanceGroup.setConfigurationsVersion((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("LastSuccessfullyAppliedConfigurations", targetDepth))
        {
          context.nextToken();
          instanceGroup.setLastSuccessfullyAppliedConfigurations(new ListUnmarshaller(ConfigurationJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("LastSuccessfullyAppliedConfigurationsVersion", targetDepth))
        {
          context.nextToken();
          instanceGroup.setLastSuccessfullyAppliedConfigurationsVersion((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("EbsBlockDevices", targetDepth))
        {
          context.nextToken();
          instanceGroup.setEbsBlockDevices(new ListUnmarshaller(EbsBlockDeviceJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("EbsOptimized", targetDepth))
        {
          context.nextToken();
          instanceGroup.setEbsOptimized((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("ShrinkPolicy", targetDepth))
        {
          context.nextToken();
          instanceGroup.setShrinkPolicy(ShrinkPolicyJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("AutoScalingPolicy", targetDepth))
        {
          context.nextToken();
          instanceGroup.setAutoScalingPolicy(AutoScalingPolicyDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return instanceGroup;
  }
  
  public static InstanceGroupJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceGroupJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */