package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BackupDescriptionJsonUnmarshaller
  implements Unmarshaller<BackupDescription, JsonUnmarshallerContext>
{
  private static BackupDescriptionJsonUnmarshaller instance;
  
  public BackupDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BackupDescription backupDescription = new BackupDescription();
    
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
        if (context.testExpression("BackupDetails", targetDepth))
        {
          context.nextToken();
          backupDescription.setBackupDetails(BackupDetailsJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("SourceTableDetails", targetDepth))
        {
          context.nextToken();
          backupDescription.setSourceTableDetails(SourceTableDetailsJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("SourceTableFeatureDetails", targetDepth))
        {
          context.nextToken();
          backupDescription.setSourceTableFeatureDetails(SourceTableFeatureDetailsJsonUnmarshaller.getInstance().unmarshall(context));
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
    return backupDescription;
  }
  
  public static BackupDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BackupDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */