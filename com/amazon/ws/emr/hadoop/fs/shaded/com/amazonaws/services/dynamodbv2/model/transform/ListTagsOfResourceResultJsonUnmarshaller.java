package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTagsOfResourceResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListTagsOfResourceResultJsonUnmarshaller
  implements Unmarshaller<ListTagsOfResourceResult, JsonUnmarshallerContext>
{
  private static ListTagsOfResourceResultJsonUnmarshaller instance;
  
  public ListTagsOfResourceResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListTagsOfResourceResult listTagsOfResourceResult = new ListTagsOfResourceResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listTagsOfResourceResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Tags", targetDepth))
        {
          context.nextToken();
          listTagsOfResourceResult.setTags(new ListUnmarshaller(TagJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("NextToken", targetDepth))
        {
          context.nextToken();
          listTagsOfResourceResult.setNextToken((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return listTagsOfResourceResult;
  }
  
  public static ListTagsOfResourceResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListTagsOfResourceResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListTagsOfResourceResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */