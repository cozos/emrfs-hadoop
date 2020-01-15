package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Shard;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ShardJsonUnmarshaller
  implements Unmarshaller<Shard, JsonUnmarshallerContext>
{
  private static ShardJsonUnmarshaller instance;
  
  public Shard unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Shard shard = new Shard();
    
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
        if (context.testExpression("ShardId", targetDepth))
        {
          context.nextToken();
          shard.setShardId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("SequenceNumberRange", targetDepth))
        {
          context.nextToken();
          shard.setSequenceNumberRange(SequenceNumberRangeJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("ParentShardId", targetDepth))
        {
          context.nextToken();
          shard.setParentShardId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return shard;
  }
  
  public static ShardJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ShardJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ShardJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */