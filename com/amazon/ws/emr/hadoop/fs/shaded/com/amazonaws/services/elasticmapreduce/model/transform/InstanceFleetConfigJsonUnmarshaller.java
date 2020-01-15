package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceFleetConfigJsonUnmarshaller
  implements Unmarshaller<InstanceFleetConfig, JsonUnmarshallerContext>
{
  private static InstanceFleetConfigJsonUnmarshaller instance;
  
  public InstanceFleetConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceFleetConfig instanceFleetConfig = new InstanceFleetConfig();
    
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
          instanceFleetConfig.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceFleetType", targetDepth))
        {
          context.nextToken();
          instanceFleetConfig.setInstanceFleetType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TargetOnDemandCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleetConfig.setTargetOnDemandCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("TargetSpotCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleetConfig.setTargetSpotCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("InstanceTypeConfigs", targetDepth))
        {
          context.nextToken();
          instanceFleetConfig.setInstanceTypeConfigs(new ListUnmarshaller(InstanceTypeConfigJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("LaunchSpecifications", targetDepth))
        {
          context.nextToken();
          instanceFleetConfig.setLaunchSpecifications(InstanceFleetProvisioningSpecificationsJsonUnmarshaller.getInstance().unmarshall(context));
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
    return instanceFleetConfig;
  }
  
  public static InstanceFleetConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceFleetConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */