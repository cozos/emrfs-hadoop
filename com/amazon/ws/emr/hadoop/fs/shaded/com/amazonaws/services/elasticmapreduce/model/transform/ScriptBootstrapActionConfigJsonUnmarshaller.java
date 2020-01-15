package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ScriptBootstrapActionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ScriptBootstrapActionConfigJsonUnmarshaller
  implements Unmarshaller<ScriptBootstrapActionConfig, JsonUnmarshallerContext>
{
  private static ScriptBootstrapActionConfigJsonUnmarshaller instance;
  
  public ScriptBootstrapActionConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ScriptBootstrapActionConfig scriptBootstrapActionConfig = new ScriptBootstrapActionConfig();
    
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
        if (context.testExpression("Path", targetDepth))
        {
          context.nextToken();
          scriptBootstrapActionConfig.setPath((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Args", targetDepth))
        {
          context.nextToken();
          scriptBootstrapActionConfig.setArgs(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
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
    return scriptBootstrapActionConfig;
  }
  
  public static ScriptBootstrapActionConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ScriptBootstrapActionConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ScriptBootstrapActionConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */