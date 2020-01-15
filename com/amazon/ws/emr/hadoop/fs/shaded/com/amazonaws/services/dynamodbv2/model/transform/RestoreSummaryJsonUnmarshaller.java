package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.RestoreSummary;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class RestoreSummaryJsonUnmarshaller
  implements Unmarshaller<RestoreSummary, JsonUnmarshallerContext>
{
  private static RestoreSummaryJsonUnmarshaller instance;
  
  public RestoreSummary unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    RestoreSummary restoreSummary = new RestoreSummary();
    
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
        if (context.testExpression("SourceBackupArn", targetDepth))
        {
          context.nextToken();
          restoreSummary.setSourceBackupArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("SourceTableArn", targetDepth))
        {
          context.nextToken();
          restoreSummary.setSourceTableArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("RestoreDateTime", targetDepth))
        {
          context.nextToken();
          restoreSummary.setRestoreDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("RestoreInProgress", targetDepth))
        {
          context.nextToken();
          restoreSummary.setRestoreInProgress((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return restoreSummary;
  }
  
  public static RestoreSummaryJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RestoreSummaryJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RestoreSummaryJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */