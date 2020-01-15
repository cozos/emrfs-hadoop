package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SequenceNumberRange;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class SequenceNumberRangeJsonUnmarshaller
  implements Unmarshaller<SequenceNumberRange, JsonUnmarshallerContext>
{
  private static SequenceNumberRangeJsonUnmarshaller instance;
  
  public SequenceNumberRange unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SequenceNumberRange sequenceNumberRange = new SequenceNumberRange();
    
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
        if (context.testExpression("StartingSequenceNumber", targetDepth))
        {
          context.nextToken();
          sequenceNumberRange.setStartingSequenceNumber((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("EndingSequenceNumber", targetDepth))
        {
          context.nextToken();
          sequenceNumberRange.setEndingSequenceNumber((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return sequenceNumberRange;
  }
  
  public static SequenceNumberRangeJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SequenceNumberRangeJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SequenceNumberRangeJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */