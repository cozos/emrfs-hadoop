package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ReEncryptResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

public class ReEncryptResultJsonUnmarshaller
  implements Unmarshaller<ReEncryptResult, JsonUnmarshallerContext>
{
  private static ReEncryptResultJsonUnmarshaller instance;
  
  public ReEncryptResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ReEncryptResult reEncryptResult = new ReEncryptResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return reEncryptResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("CiphertextBlob", targetDepth))
        {
          context.nextToken();
          reEncryptResult.setCiphertextBlob((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
        }
        if (context.testExpression("SourceKeyId", targetDepth))
        {
          context.nextToken();
          reEncryptResult.setSourceKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          reEncryptResult.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return reEncryptResult;
  }
  
  public static ReEncryptResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ReEncryptResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ReEncryptResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */