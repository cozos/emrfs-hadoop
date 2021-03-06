package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.AutoScalingPolicyDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AutoScalingPolicyDescriptionJsonUnmarshaller
  implements Unmarshaller<AutoScalingPolicyDescription, JsonUnmarshallerContext>
{
  private static AutoScalingPolicyDescriptionJsonUnmarshaller instance;
  
  public AutoScalingPolicyDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AutoScalingPolicyDescription autoScalingPolicyDescription = new AutoScalingPolicyDescription();
    
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
        if (context.testExpression("PolicyName", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyDescription.setPolicyName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TargetTrackingScalingPolicyConfiguration", targetDepth))
        {
          context.nextToken();
          autoScalingPolicyDescription
            .setTargetTrackingScalingPolicyConfiguration(
            AutoScalingTargetTrackingScalingPolicyConfigurationDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return autoScalingPolicyDescription;
  }
  
  public static AutoScalingPolicyDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AutoScalingPolicyDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.AutoScalingPolicyDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */