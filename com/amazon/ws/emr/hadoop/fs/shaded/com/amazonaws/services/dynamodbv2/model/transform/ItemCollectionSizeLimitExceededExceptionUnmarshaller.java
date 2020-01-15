package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ItemCollectionSizeLimitExceededException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ItemCollectionSizeLimitExceededExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static ItemCollectionSizeLimitExceededExceptionUnmarshaller instance;
  
  private ItemCollectionSizeLimitExceededExceptionUnmarshaller()
  {
    super(ItemCollectionSizeLimitExceededException.class, "ItemCollectionSizeLimitExceededException");
  }
  
  public ItemCollectionSizeLimitExceededException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    ItemCollectionSizeLimitExceededException itemCollectionSizeLimitExceededException = new ItemCollectionSizeLimitExceededException(null);
    
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
    return itemCollectionSizeLimitExceededException;
  }
  
  public static ItemCollectionSizeLimitExceededExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ItemCollectionSizeLimitExceededExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.ItemCollectionSizeLimitExceededExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */