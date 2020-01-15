package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.StepStatus;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class StepStatusJsonUnmarshaller
  implements Unmarshaller<StepStatus, JsonUnmarshallerContext>
{
  private static StepStatusJsonUnmarshaller instance;
  
  public StepStatus unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    StepStatus stepStatus = new StepStatus();
    
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
        if (context.testExpression("State", targetDepth))
        {
          context.nextToken();
          stepStatus.setState((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("StateChangeReason", targetDepth))
        {
          context.nextToken();
          stepStatus.setStateChangeReason(StepStateChangeReasonJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("FailureDetails", targetDepth))
        {
          context.nextToken();
          stepStatus.setFailureDetails(FailureDetailsJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Timeline", targetDepth))
        {
          context.nextToken();
          stepStatus.setTimeline(StepTimelineJsonUnmarshaller.getInstance().unmarshall(context));
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
    return stepStatus;
  }
  
  public static StepStatusJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StepStatusJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.StepStatusJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */