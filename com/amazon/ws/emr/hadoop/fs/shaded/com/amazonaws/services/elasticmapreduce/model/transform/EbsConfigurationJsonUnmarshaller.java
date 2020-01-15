package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.EbsConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class EbsConfigurationJsonUnmarshaller
  implements Unmarshaller<EbsConfiguration, JsonUnmarshallerContext>
{
  private static EbsConfigurationJsonUnmarshaller instance;
  
  public EbsConfiguration unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    EbsConfiguration ebsConfiguration = new EbsConfiguration();
    
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
        if (context.testExpression("EbsBlockDeviceConfigs", targetDepth))
        {
          context.nextToken();
          ebsConfiguration.setEbsBlockDeviceConfigs(new ListUnmarshaller(EbsBlockDeviceConfigJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("EbsOptimized", targetDepth))
        {
          context.nextToken();
          ebsConfiguration.setEbsOptimized((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return ebsConfiguration;
  }
  
  public static EbsConfigurationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EbsConfigurationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.EbsConfigurationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */