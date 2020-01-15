package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeysResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListKeysResultJsonUnmarshaller
  implements Unmarshaller<ListKeysResult, JsonUnmarshallerContext>
{
  private static ListKeysResultJsonUnmarshaller instance;
  
  public ListKeysResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListKeysResult listKeysResult = new ListKeysResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listKeysResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Keys", targetDepth))
        {
          context.nextToken();
          listKeysResult.setKeys(new ListUnmarshaller(KeyListEntryJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("NextMarker", targetDepth))
        {
          context.nextToken();
          listKeysResult.setNextMarker((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Truncated", targetDepth))
        {
          context.nextToken();
          listKeysResult.setTruncated((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return listKeysResult;
  }
  
  public static ListKeysResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListKeysResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListKeysResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */