package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceFleetProvisioningSpecifications;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceFleetProvisioningSpecificationsJsonUnmarshaller
  implements Unmarshaller<InstanceFleetProvisioningSpecifications, JsonUnmarshallerContext>
{
  private static InstanceFleetProvisioningSpecificationsJsonUnmarshaller instance;
  
  public InstanceFleetProvisioningSpecifications unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceFleetProvisioningSpecifications instanceFleetProvisioningSpecifications = new InstanceFleetProvisioningSpecifications();
    
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
        if (context.testExpression("SpotSpecification", targetDepth))
        {
          context.nextToken();
          instanceFleetProvisioningSpecifications.setSpotSpecification(SpotProvisioningSpecificationJsonUnmarshaller.getInstance()
            .unmarshall(context));
        }
      }
      else {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return instanceFleetProvisioningSpecifications;
  }
  
  public static InstanceFleetProvisioningSpecificationsJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceFleetProvisioningSpecificationsJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceFleetProvisioningSpecificationsJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */