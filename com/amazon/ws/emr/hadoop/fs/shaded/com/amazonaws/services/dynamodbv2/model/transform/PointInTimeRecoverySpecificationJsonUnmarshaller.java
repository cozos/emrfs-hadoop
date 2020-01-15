package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.PointInTimeRecoverySpecification;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class PointInTimeRecoverySpecificationJsonUnmarshaller
  implements Unmarshaller<PointInTimeRecoverySpecification, JsonUnmarshallerContext>
{
  private static PointInTimeRecoverySpecificationJsonUnmarshaller instance;
  
  public PointInTimeRecoverySpecification unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    PointInTimeRecoverySpecification pointInTimeRecoverySpecification = new PointInTimeRecoverySpecification();
    
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
        if (context.testExpression("PointInTimeRecoveryEnabled", targetDepth))
        {
          context.nextToken();
          pointInTimeRecoverySpecification.setPointInTimeRecoveryEnabled((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return pointInTimeRecoverySpecification;
  }
  
  public static PointInTimeRecoverySpecificationJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new PointInTimeRecoverySpecificationJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.PointInTimeRecoverySpecificationJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */