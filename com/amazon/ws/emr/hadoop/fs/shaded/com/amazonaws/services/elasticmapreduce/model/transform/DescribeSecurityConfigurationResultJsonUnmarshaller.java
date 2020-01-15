package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeSecurityConfigurationResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeSecurityConfigurationResultJsonUnmarshaller
  implements Unmarshaller<DescribeSecurityConfigurationResult, JsonUnmarshallerContext>
{
  private static DescribeSecurityConfigurationResultJsonUnmarshaller instance;
  
  public DescribeSecurityConfigurationResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeSecurityConfigurationResult describeSecurityConfigurationResult = new DescribeSecurityConfigurationResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeSecurityConfigurationResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          describeSecurityConfigurationResult.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("SecurityConfiguration", targetDepth))
        {
          context.nextToken();
          describeSecurityConfigurationResult.setSecurityConfiguration((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationDateTime", targetDepth))
        {
          context.nextToken();
          describeSecurityConfigurationResult.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return describeSecurityConfigurationResult;
  }
  
  public static DescribeSecurityConfigurationResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeSecurityConfigurationResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeSecurityConfigurationResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */