package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.ListInstanceGroupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListInstanceGroupsResultJsonUnmarshaller
  implements Unmarshaller<ListInstanceGroupsResult, JsonUnmarshallerContext>
{
  private static ListInstanceGroupsResultJsonUnmarshaller instance;
  
  public ListInstanceGroupsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListInstanceGroupsResult listInstanceGroupsResult = new ListInstanceGroupsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listInstanceGroupsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("InstanceGroups", targetDepth))
        {
          context.nextToken();
          listInstanceGroupsResult.setInstanceGroups(new ListUnmarshaller(InstanceGroupJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("Marker", targetDepth))
        {
          context.nextToken();
          listInstanceGroupsResult.setMarker((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return listInstanceGroupsResult;
  }
  
  public static ListInstanceGroupsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListInstanceGroupsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.ListInstanceGroupsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */