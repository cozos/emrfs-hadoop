package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DecryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

public class DecryptResultJsonUnmarshaller
  implements Unmarshaller<DecryptResult, JsonUnmarshallerContext>
{
  private static DecryptResultJsonUnmarshaller instance;
  
  public DecryptResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DecryptResult decryptResult = new DecryptResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return decryptResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          decryptResult.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Plaintext", targetDepth))
        {
          context.nextToken();
          decryptResult.setPlaintext((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
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
    return decryptResult;
  }
  
  public static DecryptResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DecryptResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DecryptResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */