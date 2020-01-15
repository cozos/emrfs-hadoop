package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SpotProvisioningSpecification;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class SpotProvisioningSpecificationJsonUnmarshaller
  implements Unmarshaller<SpotProvisioningSpecification, JsonUnmarshallerContext>
{
  private static SpotProvisioningSpecificationJsonUnmarshaller instance;
  
  public SpotProvisioningSpecification unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SpotProvisioningSpecification spotProvisioningSpecification = new SpotProvisioningSpecification();
    
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
        if (context.testExpression("TimeoutDurationMinutes", targetDepth))
        {
          context.nextToken();
          spotProvisioningSpecification.setTimeoutDurationMinutes((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("TimeoutAction", targetDepth))
        {
          context.nextToken();
          spotProvisioningSpecification.setTimeoutAction((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BlockDurationMinutes", targetDepth))
        {
          context.nextToken();
          spotProvisioningSpecification.setBlockDurationMinutes((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
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
    return spotProvisioningSpecification;
  }
  
  public static SpotProvisioningSpecificationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SpotProvisioningSpecificationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SpotProvisioningSpecificationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */