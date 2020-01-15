package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.CancelStepsInfo;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CancelStepsInfoJsonUnmarshaller
  implements Unmarshaller<CancelStepsInfo, JsonUnmarshallerContext>
{
  private static CancelStepsInfoJsonUnmarshaller instance;
  
  public CancelStepsInfo unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    CancelStepsInfo cancelStepsInfo = new CancelStepsInfo();
    
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
        if (context.testExpression("StepId", targetDepth))
        {
          context.nextToken();
          cancelStepsInfo.setStepId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Status", targetDepth))
        {
          context.nextToken();
          cancelStepsInfo.setStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Reason", targetDepth))
        {
          context.nextToken();
          cancelStepsInfo.setReason((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return cancelStepsInfo;
  }
  
  public static CancelStepsInfoJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CancelStepsInfoJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.CancelStepsInfoJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */