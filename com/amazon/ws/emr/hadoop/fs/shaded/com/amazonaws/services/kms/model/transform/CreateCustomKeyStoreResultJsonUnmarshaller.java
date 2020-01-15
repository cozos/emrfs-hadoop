package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CreateCustomKeyStoreResultJsonUnmarshaller
  implements Unmarshaller<CreateCustomKeyStoreResult, JsonUnmarshallerContext>
{
  private static CreateCustomKeyStoreResultJsonUnmarshaller instance;
  
  public CreateCustomKeyStoreResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    CreateCustomKeyStoreResult createCustomKeyStoreResult = new CreateCustomKeyStoreResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return createCustomKeyStoreResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("CustomKeyStoreId", targetDepth))
        {
          context.nextToken();
          createCustomKeyStoreResult.setCustomKeyStoreId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return createCustomKeyStoreResult;
  }
  
  public static CreateCustomKeyStoreResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateCustomKeyStoreResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateCustomKeyStoreResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */