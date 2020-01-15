package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SourceTableFeatureDetails;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class SourceTableFeatureDetailsJsonUnmarshaller
  implements Unmarshaller<SourceTableFeatureDetails, JsonUnmarshallerContext>
{
  private static SourceTableFeatureDetailsJsonUnmarshaller instance;
  
  public SourceTableFeatureDetails unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SourceTableFeatureDetails sourceTableFeatureDetails = new SourceTableFeatureDetails();
    
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
        if (context.testExpression("LocalSecondaryIndexes", targetDepth))
        {
          context.nextToken();
          sourceTableFeatureDetails.setLocalSecondaryIndexes(new ListUnmarshaller(
            LocalSecondaryIndexInfoJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("GlobalSecondaryIndexes", targetDepth))
        {
          context.nextToken();
          sourceTableFeatureDetails.setGlobalSecondaryIndexes(new ListUnmarshaller(
            GlobalSecondaryIndexInfoJsonUnmarshaller.getInstance()).unmarshall(context));
        }
        if (context.testExpression("StreamDescription", targetDepth))
        {
          context.nextToken();
          sourceTableFeatureDetails.setStreamDescription(StreamSpecificationJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("TimeToLiveDescription", targetDepth))
        {
          context.nextToken();
          sourceTableFeatureDetails.setTimeToLiveDescription(TimeToLiveDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
        }
        if (context.testExpression("SSEDescription", targetDepth))
        {
          context.nextToken();
          sourceTableFeatureDetails.setSSEDescription(SSEDescriptionJsonUnmarshaller.getInstance().unmarshall(context));
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
    return sourceTableFeatureDetails;
  }
  
  public static SourceTableFeatureDetailsJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SourceTableFeatureDetailsJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SourceTableFeatureDetailsJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */