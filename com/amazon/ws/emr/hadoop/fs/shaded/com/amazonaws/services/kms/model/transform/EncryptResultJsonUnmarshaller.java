package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.EncryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

public class EncryptResultJsonUnmarshaller
  implements Unmarshaller<EncryptResult, JsonUnmarshallerContext>
{
  private static EncryptResultJsonUnmarshaller instance;
  
  public EncryptResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    EncryptResult encryptResult = new EncryptResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return encryptResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("CiphertextBlob", targetDepth))
        {
          context.nextToken();
          encryptResult.setCiphertextBlob((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
        }
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          encryptResult.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return encryptResult;
  }
  
  public static EncryptResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new EncryptResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.EncryptResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */