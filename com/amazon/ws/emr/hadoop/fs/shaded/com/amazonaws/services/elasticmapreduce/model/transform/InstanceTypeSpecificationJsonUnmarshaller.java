package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceTypeSpecification;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceTypeSpecificationJsonUnmarshaller
  implements Unmarshaller<InstanceTypeSpecification, JsonUnmarshallerContext>
{
  private static InstanceTypeSpecificationJsonUnmarshaller instance;
  
  public InstanceTypeSpecification unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceTypeSpecification instanceTypeSpecification = new InstanceTypeSpecification();
    
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
        if (context.testExpression("InstanceType", targetDepth))
        {
          context.nextToken();
          instanceTypeSpecification.setInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("WeightedCapacity", targetDepth))
        {
          context.nextToken();
          instanceTypeSpecification.setWeightedCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("BidPrice", targetDepth))
        {
          context.nextToken();
          instanceTypeSpecification.setBidPrice((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BidPriceAsPercentageOfOnDemandPrice", targetDepth))
        {
          context.nextToken();
          instanceTypeSpecification.setBidPriceAsPercentageOfOnDemandPrice((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("Configurations", targetDepth))
        {
          context.nextToken();
          instanceTypeSpecification.setConfigurations(new ListUnmarshaller(ConfigurationJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("EbsBlockDevices", targetDepth))
        {
          context.nextToken();
          instanceTypeSpecification.setEbsBlockDevices(new ListUnmarshaller(EbsBlockDeviceJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("EbsOptimized", targetDepth))
        {
          context.nextToken();
          instanceTypeSpecification.setEbsOptimized((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return instanceTypeSpecification;
  }
  
  public static InstanceTypeSpecificationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceTypeSpecificationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceTypeSpecificationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */