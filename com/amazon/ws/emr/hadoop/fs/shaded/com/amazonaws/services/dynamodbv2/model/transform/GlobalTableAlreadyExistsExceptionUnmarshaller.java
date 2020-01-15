package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GlobalTableAlreadyExistsException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GlobalTableAlreadyExistsExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static GlobalTableAlreadyExistsExceptionUnmarshaller instance;
  
  private GlobalTableAlreadyExistsExceptionUnmarshaller()
  {
    super(GlobalTableAlreadyExistsException.class, "GlobalTableAlreadyExistsException");
  }
  
  public GlobalTableAlreadyExistsException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    GlobalTableAlreadyExistsException globalTableAlreadyExistsException = new GlobalTableAlreadyExistsException(null);
    
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
    return globalTableAlreadyExistsException;
  }
  
  public static GlobalTableAlreadyExistsExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GlobalTableAlreadyExistsExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.GlobalTableAlreadyExistsExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */