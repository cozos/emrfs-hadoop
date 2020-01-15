package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ScheduleKeyDeletionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ScheduleKeyDeletionResultJsonUnmarshaller
  implements Unmarshaller<ScheduleKeyDeletionResult, JsonUnmarshallerContext>
{
  private static ScheduleKeyDeletionResultJsonUnmarshaller instance;
  
  public ScheduleKeyDeletionResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ScheduleKeyDeletionResult scheduleKeyDeletionResult = new ScheduleKeyDeletionResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return scheduleKeyDeletionResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          scheduleKeyDeletionResult.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("DeletionDate", targetDepth))
        {
          context.nextToken();
          scheduleKeyDeletionResult.setDeletionDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return scheduleKeyDeletionResult;
  }
  
  public static ScheduleKeyDeletionResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ScheduleKeyDeletionResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ScheduleKeyDeletionResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */