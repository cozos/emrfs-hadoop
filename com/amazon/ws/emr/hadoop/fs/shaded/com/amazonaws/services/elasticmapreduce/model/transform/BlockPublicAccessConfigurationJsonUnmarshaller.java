package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BlockPublicAccessConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BlockPublicAccessConfigurationJsonUnmarshaller
  implements Unmarshaller<BlockPublicAccessConfiguration, JsonUnmarshallerContext>
{
  private static BlockPublicAccessConfigurationJsonUnmarshaller instance;
  
  public BlockPublicAccessConfiguration unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BlockPublicAccessConfiguration blockPublicAccessConfiguration = new BlockPublicAccessConfiguration();
    
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
        if (context.testExpression("BlockPublicSecurityGroupRules", targetDepth))
        {
          context.nextToken();
          blockPublicAccessConfiguration.setBlockPublicSecurityGroupRules((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("PermittedPublicSecurityGroupRuleRanges", targetDepth))
        {
          context.nextToken();
          blockPublicAccessConfiguration.setPermittedPublicSecurityGroupRuleRanges(new ListUnmarshaller(
            PortRangeJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return blockPublicAccessConfiguration;
  }
  
  public static BlockPublicAccessConfigurationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BlockPublicAccessConfigurationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BlockPublicAccessConfigurationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */