package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingRule;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ScalingRuleJsonUnmarshaller
  implements Unmarshaller<ScalingRule, JsonUnmarshallerContext>
{
  private static ScalingRuleJsonUnmarshaller instance;
  
  public ScalingRule unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ScalingRule scalingRule = new ScalingRule();
    
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
          scalingRule.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Description", targetDepth))
        {
          context.nextToken();
          scalingRule.setDescription((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Action", targetDepth))
        {
          context.nextToken();
          scalingRule.setAction(ScalingActionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Trigger", targetDepth))
        {
          context.nextToken();
          scalingRule.setTrigger(ScalingTriggerJsonUnmarshaller.getInstance().unmarshall(context));
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
    return scalingRule;
  }
  
  public static ScalingRuleJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ScalingRuleJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingRuleJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */