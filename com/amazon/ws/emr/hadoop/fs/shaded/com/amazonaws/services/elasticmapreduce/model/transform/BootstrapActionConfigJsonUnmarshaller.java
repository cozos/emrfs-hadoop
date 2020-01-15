package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.BootstrapActionConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BootstrapActionConfigJsonUnmarshaller
  implements Unmarshaller<BootstrapActionConfig, JsonUnmarshallerContext>
{
  private static BootstrapActionConfigJsonUnmarshaller instance;
  
  public BootstrapActionConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BootstrapActionConfig bootstrapActionConfig = new BootstrapActionConfig();
    
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
          bootstrapActionConfig.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ScriptBootstrapAction", targetDepth))
        {
          context.nextToken();
          bootstrapActionConfig.setScriptBootstrapAction(ScriptBootstrapActionConfigJsonUnmarshaller.getInstance().unmarshall(context));
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
    return bootstrapActionConfig;
  }
  
  public static BootstrapActionConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BootstrapActionConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.BootstrapActionConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */