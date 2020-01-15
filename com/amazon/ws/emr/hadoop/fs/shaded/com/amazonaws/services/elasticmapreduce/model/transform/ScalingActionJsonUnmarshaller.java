package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingAction;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ScalingActionJsonUnmarshaller
  implements Unmarshaller<ScalingAction, JsonUnmarshallerContext>
{
  private static ScalingActionJsonUnmarshaller instance;
  
  public ScalingAction unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ScalingAction scalingAction = new ScalingAction();
    
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
        if (context.testExpression("Market", targetDepth))
        {
          context.nextToken();
          scalingAction.setMarket((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("SimpleScalingPolicyConfiguration", targetDepth))
        {
          context.nextToken();
          scalingAction.setSimpleScalingPolicyConfiguration(SimpleScalingPolicyConfigurationJsonUnmarshaller.getInstance().unmarshall(context));
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
    return scalingAction;
  }
  
  public static ScalingActionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ScalingActionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingActionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */