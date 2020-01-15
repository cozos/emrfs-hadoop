package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ContinuousBackupsDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ContinuousBackupsDescriptionJsonUnmarshaller
  implements Unmarshaller<ContinuousBackupsDescription, JsonUnmarshallerContext>
{
  private static ContinuousBackupsDescriptionJsonUnmarshaller instance;
  
  public ContinuousBackupsDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ContinuousBackupsDescription continuousBackupsDescription = new ContinuousBackupsDescription();
    
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
        if (context.testExpression("ContinuousBackupsStatus", targetDepth))
        {
          context.nextToken();
          continuousBackupsDescription.setContinuousBackupsStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("PointInTimeRecoveryDescription", targetDepth))
        {
          context.nextToken();
          continuousBackupsDescription.setPointInTimeRecoveryDescription(PointInTimeRecoveryDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return continuousBackupsDescription;
  }
  
  public static ContinuousBackupsDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ContinuousBackupsDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ContinuousBackupsDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */