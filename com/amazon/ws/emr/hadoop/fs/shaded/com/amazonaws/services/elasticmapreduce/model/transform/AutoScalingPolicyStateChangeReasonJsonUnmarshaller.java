package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AutoScalingPolicyStateChangeReason;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingPolicyStateChangeReasonJsonUnmarshaller
  implements Unmarshaller<AutoScalingPolicyStateChangeReason, JsonUnmarshallerContext>
{
  private static AutoScalingPolicyStateChangeReasonJsonUnmarshaller instance;
  
  public AutoScalingPolicyStateChangeReason unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingPolicyStateChangeReason autoScalingPolicyStateChangeReason = new AutoScalingPolicyStateChangeReason();
    
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
        if (context.testExpression("Code", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyStateChangeReason.setCode((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Message", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyStateChangeReason.setMessage((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return autoScalingPolicyStateChangeReason;
  }
  
  public static AutoScalingPolicyStateChangeReasonJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingPolicyStateChangeReasonJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AutoScalingPolicyStateChangeReasonJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */