package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PointInTimeRecoveryDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class PointInTimeRecoveryDescriptionJsonUnmarshaller
  implements Unmarshaller<PointInTimeRecoveryDescription, JsonUnmarshallerContext>
{
  private static PointInTimeRecoveryDescriptionJsonUnmarshaller instance;
  
  public PointInTimeRecoveryDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    PointInTimeRecoveryDescription pointInTimeRecoveryDescription = new PointInTimeRecoveryDescription();
    
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
        if (context.testExpression("PointInTimeRecoveryStatus", targetDepth))
        {
          context.nextToken();
          pointInTimeRecoveryDescription.setPointInTimeRecoveryStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EarliestRestorableDateTime", targetDepth))
        {
          context.nextToken();
          pointInTimeRecoveryDescription.setEarliestRestorableDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("LatestRestorableDateTime", targetDepth))
        {
          context.nextToken();
          pointInTimeRecoveryDescription.setLatestRestorableDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return pointInTimeRecoveryDescription;
  }
  
  public static PointInTimeRecoveryDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PointInTimeRecoveryDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoveryDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */