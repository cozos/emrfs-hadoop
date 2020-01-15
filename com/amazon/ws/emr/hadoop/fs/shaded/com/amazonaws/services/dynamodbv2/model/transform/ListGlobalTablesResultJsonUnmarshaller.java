package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListGlobalTablesResultJsonUnmarshaller
  implements Unmarshaller<ListGlobalTablesResult, JsonUnmarshallerContext>
{
  private static ListGlobalTablesResultJsonUnmarshaller instance;
  
  public ListGlobalTablesResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListGlobalTablesResult listGlobalTablesResult = new ListGlobalTablesResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listGlobalTablesResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("GlobalTables", targetDepth))
        {
          context.nextToken();
          listGlobalTablesResult.setGlobalTables(new ListUnmarshaller(GlobalTableJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("LastEvaluatedGlobalTableName", targetDepth))
        {
          context.nextToken();
          listGlobalTablesResult.setLastEvaluatedGlobalTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return listGlobalTablesResult;
  }
  
  public static ListGlobalTablesResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListGlobalTablesResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListGlobalTablesResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */