package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.TimeToLiveSpecification;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class TimeToLiveSpecificationJsonUnmarshaller
  implements Unmarshaller<TimeToLiveSpecification, JsonUnmarshallerContext>
{
  private static TimeToLiveSpecificationJsonUnmarshaller instance;
  
  public TimeToLiveSpecification unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    TimeToLiveSpecification timeToLiveSpecification = new TimeToLiveSpecification();
    
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
        if (context.testExpression("Enabled", targetDepth))
        {
          context.nextToken();
          timeToLiveSpecification.setEnabled((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("AttributeName", targetDepth))
        {
          context.nextToken();
          timeToLiveSpecification.setAttributeName((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return timeToLiveSpecification;
  }
  
  public static TimeToLiveSpecificationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new TimeToLiveSpecificationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.TimeToLiveSpecificationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */