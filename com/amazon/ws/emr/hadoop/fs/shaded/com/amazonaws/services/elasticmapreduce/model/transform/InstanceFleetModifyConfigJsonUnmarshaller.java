package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetModifyConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceFleetModifyConfigJsonUnmarshaller
  implements Unmarshaller<InstanceFleetModifyConfig, JsonUnmarshallerContext>
{
  private static InstanceFleetModifyConfigJsonUnmarshaller instance;
  
  public InstanceFleetModifyConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceFleetModifyConfig instanceFleetModifyConfig = new InstanceFleetModifyConfig();
    
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
        if (context.testExpression("InstanceFleetId", targetDepth))
        {
          context.nextToken();
          instanceFleetModifyConfig.setInstanceFleetId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TargetOnDemandCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleetModifyConfig.setTargetOnDemandCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("TargetSpotCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleetModifyConfig.setTargetSpotCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
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
    return instanceFleetModifyConfig;
  }
  
  public static InstanceFleetModifyConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceFleetModifyConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetModifyConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */