package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeJobFlowsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class DescribeJobFlowsResultJsonUnmarshaller
  implements Unmarshaller<DescribeJobFlowsResult, JsonUnmarshallerContext>
{
  private static DescribeJobFlowsResultJsonUnmarshaller instance;
  
  public DescribeJobFlowsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DescribeJobFlowsResult describeJobFlowsResult = new DescribeJobFlowsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return describeJobFlowsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("JobFlows", targetDepth))
        {
          context.nextToken();
          describeJobFlowsResult.setJobFlows(new ListUnmarshaller(JobFlowDetailJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return describeJobFlowsResult;
  }
  
  public static DescribeJobFlowsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DescribeJobFlowsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.DescribeJobFlowsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */