package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTimeToLiveResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeTimeToLiveResultJsonUnmarshaller
  implements Unmarshaller<DescribeTimeToLiveResult, JsonUnmarshallerContext>
{
  private static DescribeTimeToLiveResultJsonUnmarshaller instance;
  
  public DescribeTimeToLiveResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeTimeToLiveResult describeTimeToLiveResult = new DescribeTimeToLiveResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeTimeToLiveResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("TimeToLiveDescription", targetDepth))
        {
          context.nextToken();
          describeTimeToLiveResult.setTimeToLiveDescription(TimeToLiveDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return describeTimeToLiveResult;
  }
  
  public static DescribeTimeToLiveResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeTimeToLiveResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.DescribeTimeToLiveResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */