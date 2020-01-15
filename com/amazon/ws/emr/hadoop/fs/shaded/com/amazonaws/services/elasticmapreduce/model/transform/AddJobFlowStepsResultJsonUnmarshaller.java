package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddJobFlowStepsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AddJobFlowStepsResultJsonUnmarshaller
  implements Unmarshaller<AddJobFlowStepsResult, JsonUnmarshallerContext>
{
  private static AddJobFlowStepsResultJsonUnmarshaller instance;
  
  public AddJobFlowStepsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AddJobFlowStepsResult addJobFlowStepsResult = new AddJobFlowStepsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return addJobFlowStepsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("StepIds", targetDepth))
        {
          context.nextToken();
          addJobFlowStepsResult.setStepIds(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
      }
      else {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return addJobFlowStepsResult;
  }
  
  public static AddJobFlowStepsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddJobFlowStepsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddJobFlowStepsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */