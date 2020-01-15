package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.Step;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class StepJsonUnmarshaller
  implements Unmarshaller<Step, JsonUnmarshallerContext>
{
  private static StepJsonUnmarshaller instance;
  
  public Step unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Step step = new Step();
    
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
        if (context.testExpression("Id", targetDepth))
        {
          context.nextToken();
          step.setId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Name", targetDepth))
        {
          context.nextToken();
          step.setName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Config", targetDepth))
        {
          context.nextToken();
          step.setConfig(HadoopStepConfigJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ActionOnFailure", targetDepth))
        {
          context.nextToken();
          step.setActionOnFailure((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Status", targetDepth))
        {
          context.nextToken();
          step.setStatus(StepStatusJsonUnmarshaller.getInstance().unmarshall(context));
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
    return step;
  }
  
  public static StepJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StepJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */