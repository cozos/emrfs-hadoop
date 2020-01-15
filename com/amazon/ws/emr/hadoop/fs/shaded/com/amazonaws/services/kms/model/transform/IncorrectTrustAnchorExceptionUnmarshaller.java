package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.IncorrectTrustAnchorException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class IncorrectTrustAnchorExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static IncorrectTrustAnchorExceptionUnmarshaller instance;
  
  private IncorrectTrustAnchorExceptionUnmarshaller()
  {
    super(IncorrectTrustAnchorException.class, "IncorrectTrustAnchorException");
  }
  
  public IncorrectTrustAnchorException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    IncorrectTrustAnchorException incorrectTrustAnchorException = new IncorrectTrustAnchorException(null);
    
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
    return incorrectTrustAnchorException;
  }
  
  public static IncorrectTrustAnchorExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new IncorrectTrustAnchorExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.IncorrectTrustAnchorExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */