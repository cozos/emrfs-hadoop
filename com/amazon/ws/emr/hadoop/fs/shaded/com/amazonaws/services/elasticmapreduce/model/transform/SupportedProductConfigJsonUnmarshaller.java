package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.SupportedProductConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class SupportedProductConfigJsonUnmarshaller
  implements Unmarshaller<SupportedProductConfig, JsonUnmarshallerContext>
{
  private static SupportedProductConfigJsonUnmarshaller instance;
  
  public SupportedProductConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SupportedProductConfig supportedProductConfig = new SupportedProductConfig();
    
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
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          supportedProductConfig.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Args", targetDepth))
        {
          context.nextToken();
          supportedProductConfig.setArgs(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
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
    return supportedProductConfig;
  }
  
  public static SupportedProductConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SupportedProductConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.SupportedProductConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */