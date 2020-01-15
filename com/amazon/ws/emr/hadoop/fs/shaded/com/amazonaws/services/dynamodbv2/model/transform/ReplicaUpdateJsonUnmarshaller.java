package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ReplicaUpdate;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ReplicaUpdateJsonUnmarshaller
  implements Unmarshaller<ReplicaUpdate, JsonUnmarshallerContext>
{
  private static ReplicaUpdateJsonUnmarshaller instance;
  
  public ReplicaUpdate unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ReplicaUpdate replicaUpdate = new ReplicaUpdate();
    
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
        if (context.testExpression("Create", targetDepth))
        {
          context.nextToken();
          replicaUpdate.setCreate(CreateReplicaActionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("Delete", targetDepth))
        {
          context.nextToken();
          replicaUpdate.setDelete(DeleteReplicaActionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return replicaUpdate;
  }
  
  public static ReplicaUpdateJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ReplicaUpdateJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ReplicaUpdateJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */