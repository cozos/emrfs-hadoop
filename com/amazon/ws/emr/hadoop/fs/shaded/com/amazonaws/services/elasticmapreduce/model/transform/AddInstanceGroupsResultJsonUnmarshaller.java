package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.AddInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AddInstanceGroupsResultJsonUnmarshaller
  implements Unmarshaller<AddInstanceGroupsResult, JsonUnmarshallerContext>
{
  private static AddInstanceGroupsResultJsonUnmarshaller instance;
  
  public AddInstanceGroupsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AddInstanceGroupsResult addInstanceGroupsResult = new AddInstanceGroupsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return addInstanceGroupsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("JobFlowId", targetDepth))
        {
          context.nextToken();
          addInstanceGroupsResult.setJobFlowId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("InstanceGroupIds", targetDepth))
        {
          context.nextToken();
          addInstanceGroupsResult.setInstanceGroupIds(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
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
    return addInstanceGroupsResult;
  }
  
  public static AddInstanceGroupsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AddInstanceGroupsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.AddInstanceGroupsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */