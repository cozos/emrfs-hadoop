package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BackupSummaryJsonUnmarshaller
  implements Unmarshaller<BackupSummary, JsonUnmarshallerContext>
{
  private static BackupSummaryJsonUnmarshaller instance;
  
  public BackupSummary unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BackupSummary backupSummary = new BackupSummary();
    
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
        if (context.testExpression("TableName", targetDepth))
        {
          context.nextToken();
          backupSummary.setTableName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableId", targetDepth))
        {
          context.nextToken();
          backupSummary.setTableId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TableArn", targetDepth))
        {
          context.nextToken();
          backupSummary.setTableArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupArn", targetDepth))
        {
          context.nextToken();
          backupSummary.setBackupArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupName", targetDepth))
        {
          context.nextToken();
          backupSummary.setBackupName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupCreationDateTime", targetDepth))
        {
          context.nextToken();
          backupSummary.setBackupCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("BackupExpiryDateTime", targetDepth))
        {
          context.nextToken();
          backupSummary.setBackupExpiryDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("BackupStatus", targetDepth))
        {
          context.nextToken();
          backupSummary.setBackupStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupType", targetDepth))
        {
          context.nextToken();
          backupSummary.setBackupType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupSizeBytes", targetDepth))
        {
          context.nextToken();
          backupSummary.setBackupSizeBytes((Long)context.getUnmarshaller(Long.class).unmarshall(context));
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
    return backupSummary;
  }
  
  public static BackupSummaryJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BackupSummaryJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupSummaryJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */