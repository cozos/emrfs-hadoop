package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Configuration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ConfigurationJsonUnmarshaller
  implements Unmarshaller<Configuration, JsonUnmarshallerContext>
{
  private static ConfigurationJsonUnmarshaller instance;
  
  public Configuration unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Configuration configuration = new Configuration();
    
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
        if (context.testExpression("Classification", targetDepth))
        {
          context.nextToken();
          configuration.setClassification((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Configurations", targetDepth))
        {
          context.nextToken();
          configuration.setConfigurations(new ListUnmarshaller(getInstance()).unmarshall(context));
        }
        if (context.testExpression("Properties", targetDepth))
        {
          context.nextToken();
          configuration.setProperties(new MapUnmarshaller(context.getUnmarshaller(String.class), context
            .getUnmarshaller(String.class)).unmarshall(context));
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
    return configuration;
  }
  
  public static ConfigurationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ConfigurationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ConfigurationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */