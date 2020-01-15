package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SimpleScalingPolicyConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class SimpleScalingPolicyConfigurationJsonUnmarshaller
  implements Unmarshaller<SimpleScalingPolicyConfiguration, JsonUnmarshallerContext>
{
  private static SimpleScalingPolicyConfigurationJsonUnmarshaller instance;
  
  public SimpleScalingPolicyConfiguration unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SimpleScalingPolicyConfiguration simpleScalingPolicyConfiguration = new SimpleScalingPolicyConfiguration();
    
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
        if (context.testExpression("AdjustmentType", targetDepth))
        {
          context.nextToken();
          simpleScalingPolicyConfiguration.setAdjustmentType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ScalingAdjustment", targetDepth))
        {
          context.nextToken();
          simpleScalingPolicyConfiguration.setScalingAdjustment((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("CoolDown", targetDepth))
        {
          context.nextToken();
          simpleScalingPolicyConfiguration.setCoolDown((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
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
    return simpleScalingPolicyConfiguration;
  }
  
  public static SimpleScalingPolicyConfigurationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SimpleScalingPolicyConfigurationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SimpleScalingPolicyConfigurationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */