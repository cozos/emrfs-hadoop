package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListBackupsResultJsonUnmarshaller
  implements Unmarshaller<ListBackupsResult, JsonUnmarshallerContext>
{
  private static ListBackupsResultJsonUnmarshaller instance;
  
  public ListBackupsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListBackupsResult listBackupsResult = new ListBackupsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listBackupsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("BackupSummaries", targetDepth))
        {
          context.nextToken();
          listBackupsResult.setBackupSummaries(new ListUnmarshaller(BackupSummaryJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("LastEvaluatedBackupArn", targetDepth))
        {
          context.nextToken();
          listBackupsResult.setLastEvaluatedBackupArn((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return listBackupsResult;
  }
  
  public static ListBackupsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListBackupsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ListBackupsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */