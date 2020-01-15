package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.PutAutoScalingPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class PutAutoScalingPolicyResultJsonUnmarshaller
  implements Unmarshaller<PutAutoScalingPolicyResult, JsonUnmarshallerContext>
{
  private static PutAutoScalingPolicyResultJsonUnmarshaller instance;
  
  public PutAutoScalingPolicyResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    PutAutoScalingPolicyResult putAutoScalingPolicyResult = new PutAutoScalingPolicyResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return putAutoScalingPolicyResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("ClusterId", targetDepth))
        {
          context.nextToken();
          putAutoScalingPolicyResult.setClusterId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceGroupId", targetDepth))
        {
          context.nextToken();
          putAutoScalingPolicyResult.setInstanceGroupId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AutoScalingPolicy", targetDepth))
        {
          context.nextToken();
          putAutoScalingPolicyResult.setAutoScalingPolicy(AutoScalingPolicyDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return putAutoScalingPolicyResult;
  }
  
  public static PutAutoScalingPolicyResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PutAutoScalingPolicyResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.PutAutoScalingPolicyResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */