package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateTimeToLiveResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class UpdateTimeToLiveResultJsonUnmarshaller
  implements Unmarshaller<UpdateTimeToLiveResult, JsonUnmarshallerContext>
{
  private static UpdateTimeToLiveResultJsonUnmarshaller instance;
  
  public UpdateTimeToLiveResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UpdateTimeToLiveResult updateTimeToLiveResult = new UpdateTimeToLiveResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return updateTimeToLiveResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("TimeToLiveSpecification", targetDepth))
        {
          context.nextToken();
          updateTimeToLiveResult.setTimeToLiveSpecification(TimeToLiveSpecificationJsonUnmarshaller.getInstance().unmarshall(context));
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
    return updateTimeToLiveResult;
  }
  
  public static UpdateTimeToLiveResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateTimeToLiveResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateTimeToLiveResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */