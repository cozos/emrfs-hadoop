package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ProvisionedThroughputExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ProvisionedThroughputExceededExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static ProvisionedThroughputExceededExceptionUnmarshaller instance;
  
  private ProvisionedThroughputExceededExceptionUnmarshaller()
  {
    super(ProvisionedThroughputExceededException.class, "ProvisionedThroughputExceededException");
  }
  
  public ProvisionedThroughputExceededException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    ProvisionedThroughputExceededException provisionedThroughputExceededException = new ProvisionedThroughputExceededException(null);
    
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
      if ((token != JsonToken.FIELD_NAME) && (token != JsonToken.START_OBJECT) && 
        ((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
        ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
        (context.getCurrentDepth() <= originalDepth)) {
        break;
      }
      token = context.nextToken();
    }
    return provisionedThroughputExceededException;
  }
  
  public static ProvisionedThroughputExceededExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ProvisionedThroughputExceededExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ProvisionedThroughputExceededExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */