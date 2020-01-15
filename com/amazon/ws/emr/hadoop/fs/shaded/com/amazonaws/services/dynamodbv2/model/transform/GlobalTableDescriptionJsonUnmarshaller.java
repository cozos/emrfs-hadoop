package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalTableDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GlobalTableDescriptionJsonUnmarshaller
  implements Unmarshaller<GlobalTableDescription, JsonUnmarshallerContext>
{
  private static GlobalTableDescriptionJsonUnmarshaller instance;
  
  public GlobalTableDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GlobalTableDescription globalTableDescription = new GlobalTableDescription();
    
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
        if (context.testExpression("ReplicationGroup", targetDepth))
        {
          context.nextToken();
          globalTableDescription.setReplicationGroup(new ListUnmarshaller(ReplicaDescriptionJsonUnmarshaller.getInstance())
            .unmarshall(context));
        }
        if (context.testExpression("GlobalTableArn", targetDepth))
        {
          context.nextToken();
          globalTableDescription.setGlobalTableArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationDateTime", targetDepth))
        {
          context.nextToken();
          globalTableDescription.setCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("GlobalTableStatus", targetDepth))
        {
          context.nextToken();
          globalTableDescription.setGlobalTableStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("GlobalTableName", targetDepth))
        {
          context.nextToken();
          globalTableDescription.setGlobalTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return globalTableDescription;
  }
  
  public static GlobalTableDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GlobalTableDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */