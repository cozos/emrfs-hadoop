package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicy;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingPolicyJsonUnmarshaller
  implements Unmarshaller<AutoScalingPolicy, JsonUnmarshallerContext>
{
  private static AutoScalingPolicyJsonUnmarshaller instance;
  
  public AutoScalingPolicy unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingPolicy autoScalingPolicy = new AutoScalingPolicy();
    
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
        if (context.testExpression("Constraints", targetDepth))
        {
          context.nextToken();
          autoScalingPolicy.setConstraints(ScalingConstraintsJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Rules", targetDepth))
        {
          context.nextToken();
          autoScalingPolicy.setRules(new ListUnmarshaller(ScalingRuleJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return autoScalingPolicy;
  }
  
  public static AutoScalingPolicyJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingPolicyJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */