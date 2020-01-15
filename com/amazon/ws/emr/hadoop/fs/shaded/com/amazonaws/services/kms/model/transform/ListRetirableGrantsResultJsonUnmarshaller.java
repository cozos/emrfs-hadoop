package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListRetirableGrantsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListRetirableGrantsResultJsonUnmarshaller
  implements Unmarshaller<ListRetirableGrantsResult, JsonUnmarshallerContext>
{
  private static ListRetirableGrantsResultJsonUnmarshaller instance;
  
  public ListRetirableGrantsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListRetirableGrantsResult listRetirableGrantsResult = new ListRetirableGrantsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listRetirableGrantsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Grants", targetDepth))
        {
          context.nextToken();
          listRetirableGrantsResult.setGrants(new ListUnmarshaller(GrantListEntryJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("NextMarker", targetDepth))
        {
          context.nextToken();
          listRetirableGrantsResult.setNextMarker((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Truncated", targetDepth))
        {
          context.nextToken();
          listRetirableGrantsResult.setTruncated((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return listRetirableGrantsResult;
  }
  
  public static ListRetirableGrantsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListRetirableGrantsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListRetirableGrantsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */