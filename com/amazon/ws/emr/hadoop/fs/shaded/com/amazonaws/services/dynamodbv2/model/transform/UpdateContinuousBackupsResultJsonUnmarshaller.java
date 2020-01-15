package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.UpdateContinuousBackupsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class UpdateContinuousBackupsResultJsonUnmarshaller
  implements Unmarshaller<UpdateContinuousBackupsResult, JsonUnmarshallerContext>
{
  private static UpdateContinuousBackupsResultJsonUnmarshaller instance;
  
  public UpdateContinuousBackupsResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UpdateContinuousBackupsResult updateContinuousBackupsResult = new UpdateContinuousBackupsResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return updateContinuousBackupsResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("ContinuousBackupsDescription", targetDepth))
        {
          context.nextToken();
          updateContinuousBackupsResult.setContinuousBackupsDescription(ContinuousBackupsDescriptionJsonUnmarshaller.getInstance()
            .unmarshall(context));
        }
      }
      else {
        if (((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
          ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
          (context.getCurrentDepth() <= originalDepth)) {
          break;
        }
      }
      token = context.nextToken();
    }
    return updateContinuousBackupsResult;
  }
  
  public static UpdateContinuousBackupsResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateContinuousBackupsResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.UpdateContinuousBackupsResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */