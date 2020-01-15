package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.WriteRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class WriteRequestJsonUnmarshaller
  implements Unmarshaller<WriteRequest, JsonUnmarshallerContext>
{
  private static WriteRequestJsonUnmarshaller instance;
  
  public WriteRequest unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    WriteRequest writeRequest = new WriteRequest();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return null;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("PutRequest", targetDepth))
        {
          context.nextToken();
          writeRequest.setPutRequest(PutRequestJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("DeleteRequest", targetDepth))
        {
          context.nextToken();
          writeRequest.setDeleteRequest(DeleteRequestJsonUnmarshaller.getInstance().unmarshall(context));
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
    return writeRequest;
  }
  
  public static WriteRequestJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new WriteRequestJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.WriteRequestJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */