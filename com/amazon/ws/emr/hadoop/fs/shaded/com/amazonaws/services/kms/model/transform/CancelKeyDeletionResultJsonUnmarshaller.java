package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CancelKeyDeletionResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CancelKeyDeletionResultJsonUnmarshaller
  implements Unmarshaller<CancelKeyDeletionResult, JsonUnmarshallerContext>
{
  private static CancelKeyDeletionResultJsonUnmarshaller instance;
  
  public CancelKeyDeletionResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    CancelKeyDeletionResult cancelKeyDeletionResult = new CancelKeyDeletionResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return cancelKeyDeletionResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          cancelKeyDeletionResult.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return cancelKeyDeletionResult;
  }
  
  public static CancelKeyDeletionResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CancelKeyDeletionResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CancelKeyDeletionResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */