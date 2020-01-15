package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ProvisionedThroughputDescriptionJsonUnmarshaller
  implements Unmarshaller<ProvisionedThroughputDescription, JsonUnmarshallerContext>
{
  private static ProvisionedThroughputDescriptionJsonUnmarshaller instance;
  
  public ProvisionedThroughputDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ProvisionedThroughputDescription provisionedThroughputDescription = new ProvisionedThroughputDescription();
    
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
        if (context.testExpression("LastIncreaseDateTime", targetDepth))
        {
          context.nextToken();
          provisionedThroughputDescription.setLastIncreaseDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("LastDecreaseDateTime", targetDepth))
        {
          context.nextToken();
          provisionedThroughputDescription.setLastDecreaseDateTime(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("NumberOfDecreasesToday", targetDepth))
        {
          context.nextToken();
          provisionedThroughputDescription.setNumberOfDecreasesToday((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("ReadCapacityUnits", targetDepth))
        {
          context.nextToken();
          provisionedThroughputDescription.setReadCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
        }
        if (context.testExpression("WriteCapacityUnits", targetDepth))
        {
          context.nextToken();
          provisionedThroughputDescription.setWriteCapacityUnits((Long)context.getUnmarshaller(Long.class).unmarshall(context));
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
    return provisionedThroughputDescription;
  }
  
  public static ProvisionedThroughputDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ProvisionedThroughputDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */