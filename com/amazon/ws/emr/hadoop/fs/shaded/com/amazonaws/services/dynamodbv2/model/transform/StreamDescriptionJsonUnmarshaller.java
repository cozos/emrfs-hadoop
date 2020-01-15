package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.StreamDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class StreamDescriptionJsonUnmarshaller
  implements Unmarshaller<StreamDescription, JsonUnmarshallerContext>
{
  private static StreamDescriptionJsonUnmarshaller instance;
  
  public StreamDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    StreamDescription streamDescription = new StreamDescription();
    
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
          streamDescription.setStreamArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("StreamLabel", targetDepth))
        {
          context.nextToken();
          streamDescription.setStreamLabel((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("StreamStatus", targetDepth))
        {
          context.nextToken();
          streamDescription.setStreamStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("StreamViewType", targetDepth))
        {
          context.nextToken();
          streamDescription.setStreamViewType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationRequestDateTime", targetDepth))
        {
          context.nextToken();
          streamDescription.setCreationRequestDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          streamDescription.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeySchema", targetDepth))
        {
          context.nextToken();
          streamDescription.setKeySchema(new ListUnmarshaller(KeySchemaElementJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("Shards", targetDepth))
        {
          context.nextToken();
          streamDescription.setShards(new ListUnmarshaller(ShardJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("LastEvaluatedShardId", targetDepth))
        {
          context.nextToken();
          streamDescription.setLastEvaluatedShardId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return streamDescription;
  }
  
  public static StreamDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new StreamDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.StreamDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */