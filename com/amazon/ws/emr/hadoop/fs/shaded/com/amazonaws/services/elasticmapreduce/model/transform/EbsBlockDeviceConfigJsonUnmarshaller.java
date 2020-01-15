package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsBlockDeviceConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class EbsBlockDeviceConfigJsonUnmarshaller
  implements Unmarshaller<EbsBlockDeviceConfig, JsonUnmarshallerContext>
{
  private static EbsBlockDeviceConfigJsonUnmarshaller instance;
  
  public EbsBlockDeviceConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    EbsBlockDeviceConfig ebsBlockDeviceConfig = new EbsBlockDeviceConfig();
    
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
        if (context.testExpression("VolumeSpecification", targetDepth))
        {
          context.nextToken();
          ebsBlockDeviceConfig.setVolumeSpecification(VolumeSpecificationJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("VolumesPerInstance", targetDepth))
        {
          context.nextToken();
          ebsBlockDeviceConfig.setVolumesPerInstance((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
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
    return ebsBlockDeviceConfig;
  }
  
  public static EbsBlockDeviceConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EbsBlockDeviceConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsBlockDeviceConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */