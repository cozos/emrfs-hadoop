package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleet;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceFleetJsonUnmarshaller
  implements Unmarshaller<InstanceFleet, JsonUnmarshallerContext>
{
  private static InstanceFleetJsonUnmarshaller instance;
  
  public InstanceFleet unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceFleet instanceFleet = new InstanceFleet();
    
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
        if (context.testExpression("Id", targetDepth))
        {
          context.nextToken();
          instanceFleet.setId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          instanceFleet.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Status", targetDepth))
        {
          context.nextToken();
          instanceFleet.setStatus(InstanceFleetStatusJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("InstanceFleetType", targetDepth))
        {
          context.nextToken();
          instanceFleet.setInstanceFleetType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TargetOnDemandCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleet.setTargetOnDemandCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("TargetSpotCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleet.setTargetSpotCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedOnDemandCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleet.setProvisionedOnDemandCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("ProvisionedSpotCapacity", targetDepth))
        {
          context.nextToken();
          instanceFleet.setProvisionedSpotCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("InstanceTypeSpecifications", targetDepth))
        {
          context.nextToken();
          instanceFleet.setInstanceTypeSpecifications(new ListUnmarshaller(
            InstanceTypeSpecificationJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("LaunchSpecifications", targetDepth))
        {
          context.nextToken();
          instanceFleet.setLaunchSpecifications(InstanceFleetProvisioningSpecificationsJsonUnmarshaller.getInstance().unmarshall(context));
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
    return instanceFleet;
  }
  
  public static InstanceFleetJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceFleetJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */