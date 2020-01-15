package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScalingConstraints;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ScalingConstraintsJsonUnmarshaller
  implements Unmarshaller<ScalingConstraints, JsonUnmarshallerContext>
{
  private static ScalingConstraintsJsonUnmarshaller instance;
  
  public ScalingConstraints unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ScalingConstraints scalingConstraints = new ScalingConstraints();
    
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
        if (context.testExpression("MinCapacity", targetDepth))
        {
          context.nextToken();
          scalingConstraints.setMinCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("MaxCapacity", targetDepth))
        {
          context.nextToken();
          scalingConstraints.setMaxCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
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
    return scalingConstraints;
  }
  
  public static ScalingConstraintsJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ScalingConstraintsJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScalingConstraintsJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */