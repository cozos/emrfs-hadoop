package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceGroupModifyConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceGroupModifyConfigJsonUnmarshaller
  implements Unmarshaller<InstanceGroupModifyConfig, JsonUnmarshallerContext>
{
  private static InstanceGroupModifyConfigJsonUnmarshaller instance;
  
  public InstanceGroupModifyConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceGroupModifyConfig instanceGroupModifyConfig = new InstanceGroupModifyConfig();
    
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
        if (context.testExpression("InstanceGroupId", targetDepth))
        {
          context.nextToken();
          instanceGroupModifyConfig.setInstanceGroupId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceCount", targetDepth))
        {
          context.nextToken();
          instanceGroupModifyConfig.setInstanceCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("EC2InstanceIdsToTerminate", targetDepth))
        {
          context.nextToken();
          instanceGroupModifyConfig.setEC2InstanceIdsToTerminate(new ListUnmarshaller(context.getUnmarshaller(String.class))
            .unmarshall(context));
        }
        if (context.testExpression("ShrinkPolicy", targetDepth))
        {
          context.nextToken();
          instanceGroupModifyConfig.setShrinkPolicy(ShrinkPolicyJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Configurations", targetDepth))
        {
          context.nextToken();
          instanceGroupModifyConfig.setConfigurations(new ListUnmarshaller(ConfigurationJsonUnmarshaller.getInstance())
            .unmarshall(context));
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
    return instanceGroupModifyConfig;
  }
  
  public static InstanceGroupModifyConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceGroupModifyConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceGroupModifyConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */