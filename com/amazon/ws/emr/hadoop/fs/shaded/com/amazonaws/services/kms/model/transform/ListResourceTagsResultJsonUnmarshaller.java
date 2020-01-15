package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListResourceTagsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListResourceTagsResultJsonUnmarshaller
  implements Unmarshaller<ListResourceTagsResult, JsonUnmarshallerContext>
{
  private static ListResourceTagsResultJsonUnmarshaller instance;
  
  public ListResourceTagsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListResourceTagsResult listResourceTagsResult = new ListResourceTagsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listResourceTagsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Tags", targetDepth))
        {
          context.nextToken();
          listResourceTagsResult.setTags(new ListUnmarshaller(TagJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("NextMarker", targetDepth))
        {
          context.nextToken();
          listResourceTagsResult.setNextMarker((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Truncated", targetDepth))
        {
          context.nextToken();
          listResourceTagsResult.setTruncated((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return listResourceTagsResult;
  }
  
  public static ListResourceTagsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListResourceTagsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListResourceTagsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */