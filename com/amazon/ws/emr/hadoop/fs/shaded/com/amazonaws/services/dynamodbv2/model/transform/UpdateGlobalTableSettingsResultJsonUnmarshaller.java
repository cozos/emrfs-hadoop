package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateGlobalTableSettingsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class UpdateGlobalTableSettingsResultJsonUnmarshaller
  implements Unmarshaller<UpdateGlobalTableSettingsResult, JsonUnmarshallerContext>
{
  private static UpdateGlobalTableSettingsResultJsonUnmarshaller instance;
  
  public UpdateGlobalTableSettingsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UpdateGlobalTableSettingsResult updateGlobalTableSettingsResult = new UpdateGlobalTableSettingsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return updateGlobalTableSettingsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("GlobalTableName", targetDepth))
        {
          context.nextToken();
          updateGlobalTableSettingsResult.setGlobalTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ReplicaSettings", targetDepth))
        {
          context.nextToken();
          updateGlobalTableSettingsResult.setReplicaSettings(new ListUnmarshaller(
            ReplicaSettingsDescriptionJsonUnmarshaller.getInstance()).unmarshall(context));
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
    return updateGlobalTableSettingsResult;
  }
  
  public static UpdateGlobalTableSettingsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateGlobalTableSettingsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateGlobalTableSettingsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */