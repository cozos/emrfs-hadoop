package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

public class GenerateDataKeyResultJsonUnmarshaller
  implements Unmarshaller<GenerateDataKeyResult, JsonUnmarshallerContext>
{
  private static GenerateDataKeyResultJsonUnmarshaller instance;
  
  public GenerateDataKeyResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GenerateDataKeyResult generateDataKeyResult = new GenerateDataKeyResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return generateDataKeyResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("CiphertextBlob", targetDepth))
        {
          context.nextToken();
          generateDataKeyResult.setCiphertextBlob((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
        }
        if (context.testExpression("Plaintext", targetDepth))
        {
          context.nextToken();
          generateDataKeyResult.setPlaintext((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
        }
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          generateDataKeyResult.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return generateDataKeyResult;
  }
  
  public static GenerateDataKeyResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GenerateDataKeyResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GenerateDataKeyResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */