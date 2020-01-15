package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeLimitsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeLimitsResultJsonUnmarshaller
  implements Unmarshaller<DescribeLimitsResult, JsonUnmarshallerContext>
{
  private static DescribeLimitsResultJsonUnmarshaller instance;
  
  public DescribeLimitsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeLimitsResult describeLimitsResult = new DescribeLimitsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeLimitsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("AccountMaxReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          describeLimitsResult.setAccountMaxReadCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("AccountMaxWriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          describeLimitsResult.setAccountMaxWriteCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("TableMaxReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          describeLimitsResult.setTableMaxReadCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("TableMaxWriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          describeLimitsResult.setTableMaxWriteCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
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
    return describeLimitsResult;
  }
  
  public static DescribeLimitsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeLimitsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeLimitsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */