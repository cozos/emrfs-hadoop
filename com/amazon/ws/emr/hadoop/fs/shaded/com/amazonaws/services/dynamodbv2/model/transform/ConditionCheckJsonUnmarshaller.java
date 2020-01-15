package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ConditionCheck;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.MapUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ConditionCheckJsonUnmarshaller
  implements Unmarshaller<ConditionCheck, JsonUnmarshallerContext>
{
  private static ConditionCheckJsonUnmarshaller instance;
  
  public ConditionCheck unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ConditionCheck conditionCheck = new ConditionCheck();
    
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
          conditionCheck.setKey(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          conditionCheck.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ConditionExpression", targetDepth))
        {
          context.nextToken();
          conditionCheck.setConditionExpression((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeNames", targetDepth))
        {
          context.nextToken();
          conditionCheck.setExpressionAttributeNames(new MapUnmarshaller(context.getUnmarshaller(String.class), context
            .getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("ExpressionAttributeValues", targetDepth))
        {
          context.nextToken();
          conditionCheck.setExpressionAttributeValues(new MapUnmarshaller(context.getUnmarshaller(String.class), 
            AttributeValueJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("ReturnValuesOnConditionCheckFailure", targetDepth))
        {
          context.nextToken();
          conditionCheck.setReturnValuesOnConditionCheckFailure((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return conditionCheck;
  }
  
  public static ConditionCheckJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ConditionCheckJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ConditionCheckJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */