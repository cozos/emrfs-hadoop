package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Instance;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class InstanceJsonUnmarshaller
  implements Unmarshaller<Instance, JsonUnmarshallerContext>
{
  private static InstanceJsonUnmarshaller instance;
  
  public Instance unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Instance instance = new Instance();
    
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
          instance.setId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Ec2InstanceId", targetDepth))
        {
          context.nextToken();
          instance.setEc2InstanceId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("PublicDnsName", targetDepth))
        {
          context.nextToken();
          instance.setPublicDnsName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("PublicIpAddress", targetDepth))
        {
          context.nextToken();
          instance.setPublicIpAddress((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("PrivateDnsName", targetDepth))
        {
          context.nextToken();
          instance.setPrivateDnsName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("PrivateIpAddress", targetDepth))
        {
          context.nextToken();
          instance.setPrivateIpAddress((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Status", targetDepth))
        {
          context.nextToken();
          instance.setStatus(InstanceStatusJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("InstanceGroupId", targetDepth))
        {
          context.nextToken();
          instance.setInstanceGroupId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceFleetId", targetDepth))
        {
          context.nextToken();
          instance.setInstanceFleetId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Market", targetDepth))
        {
          context.nextToken();
          instance.setMarket((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceType", targetDepth))
        {
          context.nextToken();
          instance.setInstanceType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EbsVolumes", targetDepth))
        {
          context.nextToken();
          instance.setEbsVolumes(new ListUnmarshaller(EbsVolumeJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return instance;
  }
  
  public static InstanceJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new InstanceJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.InstanceJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */