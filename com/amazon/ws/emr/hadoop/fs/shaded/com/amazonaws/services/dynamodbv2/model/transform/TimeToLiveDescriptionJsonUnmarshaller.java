package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TimeToLiveDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class TimeToLiveDescriptionJsonUnmarshaller
  implements Unmarshaller<TimeToLiveDescription, JsonUnmarshallerContext>
{
  private static TimeToLiveDescriptionJsonUnmarshaller instance;
  
  public TimeToLiveDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TimeToLiveDescription timeToLiveDescription = new TimeToLiveDescription();
    
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
        if (context.testExpression("TimeToLiveStatus", targetDepth))
        {
          context.nextToken();
          timeToLiveDescription.setTimeToLiveStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AttributeName", targetDepth))
        {
          context.nextToken();
          timeToLiveDescription.setAttributeName((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return timeToLiveDescription;
  }
  
  public static TimeToLiveDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TimeToLiveDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TimeToLiveDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */