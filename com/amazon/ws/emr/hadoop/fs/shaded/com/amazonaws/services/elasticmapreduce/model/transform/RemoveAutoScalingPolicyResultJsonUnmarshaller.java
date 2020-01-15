package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.RemoveAutoScalingPolicyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class RemoveAutoScalingPolicyResultJsonUnmarshaller
  implements Unmarshaller<RemoveAutoScalingPolicyResult, JsonUnmarshallerContext>
{
  private static RemoveAutoScalingPolicyResultJsonUnmarshaller instance;
  
  public RemoveAutoScalingPolicyResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    RemoveAutoScalingPolicyResult removeAutoScalingPolicyResult = new RemoveAutoScalingPolicyResult();
    
    return removeAutoScalingPolicyResult;
  }
  
  public static RemoveAutoScalingPolicyResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RemoveAutoScalingPolicyResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.RemoveAutoScalingPolicyResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */