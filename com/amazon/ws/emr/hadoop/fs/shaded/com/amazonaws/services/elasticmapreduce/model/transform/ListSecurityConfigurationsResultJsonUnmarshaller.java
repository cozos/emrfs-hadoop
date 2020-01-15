package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListSecurityConfigurationsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListSecurityConfigurationsResultJsonUnmarshaller
  implements Unmarshaller<ListSecurityConfigurationsResult, JsonUnmarshallerContext>
{
  private static ListSecurityConfigurationsResultJsonUnmarshaller instance;
  
  public ListSecurityConfigurationsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListSecurityConfigurationsResult listSecurityConfigurationsResult = new ListSecurityConfigurationsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listSecurityConfigurationsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("SecurityConfigurations", targetDepth))
        {
          context.nextToken();
          listSecurityConfigurationsResult.setSecurityConfigurations(new ListUnmarshaller(
            SecurityConfigurationSummaryJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("Marker", targetDepth))
        {
          context.nextToken();
          listSecurityConfigurationsResult.setMarker((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return listSecurityConfigurationsResult;
  }
  
  public static ListSecurityConfigurationsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListSecurityConfigurationsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListSecurityConfigurationsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */