package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeGlobalTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeGlobalTableResultJsonUnmarshaller
  implements Unmarshaller<DescribeGlobalTableResult, JsonUnmarshallerContext>
{
  private static DescribeGlobalTableResultJsonUnmarshaller instance;
  
  public DescribeGlobalTableResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeGlobalTableResult describeGlobalTableResult = new DescribeGlobalTableResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeGlobalTableResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("GlobalTableDescription", targetDepth))
        {
          context.nextToken();
          describeGlobalTableResult.setGlobalTableDescription(GlobalTableDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return describeGlobalTableResult;
  }
  
  public static DescribeGlobalTableResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeGlobalTableResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeGlobalTableResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */