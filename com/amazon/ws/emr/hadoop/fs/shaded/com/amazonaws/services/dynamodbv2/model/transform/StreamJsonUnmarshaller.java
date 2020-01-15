package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Stream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class StreamJsonUnmarshaller
  implements Unmarshaller<Stream, JsonUnmarshallerContext>
{
  private static StreamJsonUnmarshaller instance;
  
  public Stream unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Stream stream = new Stream();
    
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
        if (context.testExpression("StreamArn", targetDepth))
        {
          context.nextToken();
          stream.setStreamArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          stream.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("StreamLabel", targetDepth))
        {
          context.nextToken();
          stream.setStreamLabel((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return stream;
  }
  
  public static StreamJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StreamJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */