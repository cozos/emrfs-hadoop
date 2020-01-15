package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BlockPublicAccessConfigurationMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BlockPublicAccessConfigurationMetadataJsonUnmarshaller
  implements Unmarshaller<BlockPublicAccessConfigurationMetadata, JsonUnmarshallerContext>
{
  private static BlockPublicAccessConfigurationMetadataJsonUnmarshaller instance;
  
  public BlockPublicAccessConfigurationMetadata unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BlockPublicAccessConfigurationMetadata blockPublicAccessConfigurationMetadata = new BlockPublicAccessConfigurationMetadata();
    
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
        if (context.testExpression("CreationDateTime", targetDepth))
        {
          context.nextToken();
          blockPublicAccessConfigurationMetadata.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("CreatedByArn", targetDepth))
        {
          context.nextToken();
          blockPublicAccessConfigurationMetadata.setCreatedByArn((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return blockPublicAccessConfigurationMetadata;
  }
  
  public static BlockPublicAccessConfigurationMetadataJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BlockPublicAccessConfigurationMetadataJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BlockPublicAccessConfigurationMetadataJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */