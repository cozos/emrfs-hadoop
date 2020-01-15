package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepConfig;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class StepConfigJsonUnmarshaller
  implements Unmarshaller<StepConfig, JsonUnmarshallerContext>
{
  private static StepConfigJsonUnmarshaller instance;
  
  public StepConfig unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    StepConfig stepConfig = new StepConfig();
    
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
          stepConfig.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ActionOnFailure", targetDepth))
        {
          context.nextToken();
          stepConfig.setActionOnFailure((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("HadoopJarStep", targetDepth))
        {
          context.nextToken();
          stepConfig.setHadoopJarStep(HadoopJarStepConfigJsonUnmarshaller.getInstance().unmarshall(context));
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
    return stepConfig;
  }
  
  public static StepConfigJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StepConfigJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepConfigJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */