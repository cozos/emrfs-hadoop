package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.InstanceTypeConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceTypeConfigJsonUnmarshaller
  implements Unmarshaller<InstanceTypeConfig, JsonUnmarshallerContext>
{
  private static InstanceTypeConfigJsonUnmarshaller instance;
  
  public InstanceTypeConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    InstanceTypeConfig instanceTypeConfig = new InstanceTypeConfig();
    
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
          instanceTypeConfig.setInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("WeightedCapacity", targetDepth))
        {
          context.nextToken();
          instanceTypeConfig.setWeightedCapacity((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("BidPrice", targetDepth))
        {
          context.nextToken();
          instanceTypeConfig.setBidPrice((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BidPriceAsPercentageOfOnDemandPrice", targetDepth))
        {
          context.nextToken();
          instanceTypeConfig.setBidPriceAsPercentageOfOnDemandPrice((Double)context.getUnmarshaller(Double.class).unmarshall(context));
        }
        if (context.testExpression("EbsConfiguration", targetDepth))
        {
          context.nextToken();
          instanceTypeConfig.setEbsConfiguration(EbsConfigurationJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Configurations", targetDepth))
        {
          context.nextToken();
          instanceTypeConfig.setConfigurations(new ListUnmarshaller(ConfigurationJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return instanceTypeConfig;
  }
  
  public static InstanceTypeConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceTypeConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceTypeConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */