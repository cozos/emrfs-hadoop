package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.Record;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class RecordJsonUnmarshaller
  implements Unmarshaller<Record, JsonUnmarshallerContext>
{
  private static RecordJsonUnmarshaller instance;
  
  public Record unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    Record record = new Record();
    
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
        if (context.testExpression("eventID", targetDepth))
        {
          context.nextToken();
          record.setEventID((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("eventName", targetDepth))
        {
          context.nextToken();
          record.setEventName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("eventVersion", targetDepth))
        {
          context.nextToken();
          record.setEventVersion((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("eventSource", targetDepth))
        {
          context.nextToken();
          record.setEventSource((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("awsRegion", targetDepth))
        {
          context.nextToken();
          record.setAwsRegion((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("dynamodb", targetDepth))
        {
          context.nextToken();
          record.setDynamodb(StreamRecordJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("userIdentity", targetDepth))
        {
          context.nextToken();
          record.setUserIdentity(IdentityJsonUnmarshaller.getInstance().unmarshall(context));
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
    return record;
  }
  
  public static RecordJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new RecordJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.RecordJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */