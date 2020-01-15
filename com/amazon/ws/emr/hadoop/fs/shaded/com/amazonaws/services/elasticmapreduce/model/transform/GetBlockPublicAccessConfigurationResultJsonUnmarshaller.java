package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.GetBlockPublicAccessConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GetBlockPublicAccessConfigurationResultJsonUnmarshaller
  implements Unmarshaller<GetBlockPublicAccessConfigurationResult, JsonUnmarshallerContext>
{
  private static GetBlockPublicAccessConfigurationResultJsonUnmarshaller instance;
  
  public GetBlockPublicAccessConfigurationResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GetBlockPublicAccessConfigurationResult getBlockPublicAccessConfigurationResult = new GetBlockPublicAccessConfigurationResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return getBlockPublicAccessConfigurationResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("BlockPublicAccessConfiguration", targetDepth))
        {
          context.nextToken();
          getBlockPublicAccessConfigurationResult.setBlockPublicAccessConfiguration(BlockPublicAccessConfigurationJsonUnmarshaller.getInstance()
            .unmarshall(context));
        }
        if (context.testExpression("BlockPublicAccessConfigurationMetadata", targetDepth))
        {
          context.nextToken();
          getBlockPublicAccessConfigurationResult.setBlockPublicAccessConfigurationMetadata(
            BlockPublicAccessConfigurationMetadataJsonUnmarshaller.getInstance().unmarshall(context));
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
    return getBlockPublicAccessConfigurationResult;
  }
  
  public static GetBlockPublicAccessConfigurationResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetBlockPublicAccessConfigurationResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.GetBlockPublicAccessConfigurationResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */