package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class QueryResultJsonUnmarshaller
  implements Unmarshaller<QueryResult, JsonUnmarshallerContext>
{
  private static QueryResultJsonUnmarshaller instance;
  
  public QueryResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    QueryResult queryResult = new QueryResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return queryResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Items", targetDepth))
        {
          context.nextToken();
          queryResult.setItems(new ListUnmarshaller(new MapUnmarshaller(context
            .getUnmarshaller(String.class), AttributeValueJsonUnmarshaller.getInstance())).unmarshall(context));
        }
        if (context.testExpression("Count", targetDepth))
        {
          context.nextToken();
          queryResult.setCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("ScannedCount", targetDepth))
        {
          context.nextToken();
          queryResult.setScannedCount((Integer)context.getUnmarshaller(Integer.class).unmarshall(context));
        }
        if (context.testExpression("LastEvaluatedKey", targetDepth))
        {
          context.nextToken();
          queryResult.setLastEvaluatedKey(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ConsumedCapacity", targetDepth))
        {
          context.nextToken();
          queryResult.setConsumedCapacity(ConsumedCapacityJsonUnmarshaller.getInstance().unmarshall(context));
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
    return queryResult;
  }
  
  public static QueryResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new QueryResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.QueryResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */