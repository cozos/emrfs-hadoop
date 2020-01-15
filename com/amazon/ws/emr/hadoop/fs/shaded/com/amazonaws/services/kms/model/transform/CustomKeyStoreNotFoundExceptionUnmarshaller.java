package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CustomKeyStoreNotFoundException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CustomKeyStoreNotFoundExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static CustomKeyStoreNotFoundExceptionUnmarshaller instance;
  
  private CustomKeyStoreNotFoundExceptionUnmarshaller()
  {
    super(CustomKeyStoreNotFoundException.class, "CustomKeyStoreNotFoundException");
  }
  
  public CustomKeyStoreNotFoundException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    CustomKeyStoreNotFoundException customKeyStoreNotFoundException = new CustomKeyStoreNotFoundException(null);
    
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
    return customKeyStoreNotFoundException;
  }
  
  public static CustomKeyStoreNotFoundExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CustomKeyStoreNotFoundExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoreNotFoundExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */