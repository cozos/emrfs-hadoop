package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.HadoopStepConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class HadoopStepConfigJsonUnmarshaller
  implements Unmarshaller<HadoopStepConfig, JsonUnmarshallerContext>
{
  private static HadoopStepConfigJsonUnmarshaller instance;
  
  public HadoopStepConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    HadoopStepConfig hadoopStepConfig = new HadoopStepConfig();
    
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
        if (context.testExpression("Jar", targetDepth))
        {
          context.nextToken();
          hadoopStepConfig.setJar((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Properties", targetDepth))
        {
          context.nextToken();
          hadoopStepConfig.setProperties(new MapUnmarshaller(context.getUnmarshaller(String.class), context
            .getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("MainClass", targetDepth))
        {
          context.nextToken();
          hadoopStepConfig.setMainClass((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Args", targetDepth))
        {
          context.nextToken();
          hadoopStepConfig.setArgs(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
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
    return hadoopStepConfig;
  }
  
  public static HadoopStepConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new HadoopStepConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.HadoopStepConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */