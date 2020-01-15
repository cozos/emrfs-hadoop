package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.BackupDetails;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class BackupDetailsJsonUnmarshaller
  implements Unmarshaller<BackupDetails, JsonUnmarshallerContext>
{
  private static BackupDetailsJsonUnmarshaller instance;
  
  public BackupDetails unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    BackupDetails backupDetails = new BackupDetails();
    
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
        if (context.testExpression("BackupArn", targetDepth))
        {
          context.nextToken();
          backupDetails.setBackupArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupName", targetDepth))
        {
          context.nextToken();
          backupDetails.setBackupName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupSizeBytes", targetDepth))
        {
          context.nextToken();
          backupDetails.setBackupSizeBytes((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("BackupStatus", targetDepth))
        {
          context.nextToken();
          backupDetails.setBackupStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupType", targetDepth))
        {
          context.nextToken();
          backupDetails.setBackupType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("BackupCreationDateTime", targetDepth))
        {
          context.nextToken();
          backupDetails.setBackupCreationDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("BackupExpiryDateTime", targetDepth))
        {
          context.nextToken();
          backupDetails.setBackupExpiryDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return backupDetails;
  }
  
  public static BackupDetailsJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new BackupDetailsJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.BackupDetailsJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */