package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreTableToPointInTimeResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class RestoreTableToPointInTimeResultJsonUnmarshaller
  implements Unmarshaller<RestoreTableToPointInTimeResult, JsonUnmarshallerContext>
{
  private static RestoreTableToPointInTimeResultJsonUnmarshaller instance;
  
  public RestoreTableToPointInTimeResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    RestoreTableToPointInTimeResult restoreTableToPointInTimeResult = new RestoreTableToPointInTimeResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return restoreTableToPointInTimeResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("TableDescription", targetDepth))
        {
          context.nextToken();
          restoreTableToPointInTimeResult.setTableDescription(TableDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return restoreTableToPointInTimeResult;
  }
  
  public static RestoreTableToPointInTimeResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RestoreTableToPointInTimeResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreTableToPointInTimeResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */