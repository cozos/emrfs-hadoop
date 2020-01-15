package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepDetail;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class StepDetailJsonUnmarshaller
  implements Unmarshaller<StepDetail, JsonUnmarshallerContext>
{
  private static StepDetailJsonUnmarshaller instance;
  
  public StepDetail unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    StepDetail stepDetail = new StepDetail();
    
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
        if (context.testExpression("StepConfig", targetDepth))
        {
          context.nextToken();
          stepDetail.setStepConfig(StepConfigJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ExecutionStatusDetail", targetDepth))
        {
          context.nextToken();
          stepDetail.setExecutionStatusDetail(StepExecutionStatusDetailJsonUnmarshaller.getInstance().unmarshall(context));
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
    return stepDetail;
  }
  
  public static StepDetailJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StepDetailJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepDetailJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */