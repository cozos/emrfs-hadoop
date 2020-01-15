package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CustomKeyStoreHasCMKsException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CustomKeyStoreHasCMKsExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static CustomKeyStoreHasCMKsExceptionUnmarshaller instance;
  
  private CustomKeyStoreHasCMKsExceptionUnmarshaller()
  {
    super(CustomKeyStoreHasCMKsException.class, "CustomKeyStoreHasCMKsException");
  }
  
  public CustomKeyStoreHasCMKsException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    CustomKeyStoreHasCMKsException customKeyStoreHasCMKsException = new CustomKeyStoreHasCMKsException(null);
    
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
    return customKeyStoreHasCMKsException;
  }
  
  public static CustomKeyStoreHasCMKsExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CustomKeyStoreHasCMKsExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoreHasCMKsExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */