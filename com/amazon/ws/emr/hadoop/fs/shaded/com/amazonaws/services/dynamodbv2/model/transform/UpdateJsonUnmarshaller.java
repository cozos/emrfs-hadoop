package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Update;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class UpdateJsonUnmarshaller
  implements Unmarshaller<Update, JsonUnmarshallerContext>
{
  private static UpdateJsonUnmarshaller instance;
  
  public Update unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Update update = new Update();
    
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
        if (context.testExpression("Key", targetDepth))
        {
          context.nextToken();
          update.setKey(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("UpdateExpression", targetDepth))
        {
          context.nextToken();
          update.setUpdateExpression((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          update.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ConditionExpression", targetDepth))
        {
          context.nextToken();
          update.setConditionExpression((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeNames", targetDepth))
        {
          context.nextToken();
          update.setExpressionAttributeNames(new MapUnmarshaller(context.getUnmarshaller(String.class), context
            .getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeValues", targetDepth))
        {
          context.nextToken();
          update.setExpressionAttributeValues(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ReturnValuesOnConditionCheckFailure", targetDepth))
        {
          context.nextToken();
          update.setReturnValuesOnConditionCheckFailure((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return update;
  }
  
  public static UpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */