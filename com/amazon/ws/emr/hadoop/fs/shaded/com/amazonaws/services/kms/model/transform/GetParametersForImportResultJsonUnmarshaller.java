package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetParametersForImportResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;
import java.nio.ByteBuffer;

public class GetParametersForImportResultJsonUnmarshaller
  implements Unmarshaller<GetParametersForImportResult, JsonUnmarshallerContext>
{
  private static GetParametersForImportResultJsonUnmarshaller instance;
  
  public GetParametersForImportResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GetParametersForImportResult getParametersForImportResult = new GetParametersForImportResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return getParametersForImportResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          getParametersForImportResult.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ImportToken", targetDepth))
        {
          context.nextToken();
          getParametersForImportResult.setImportToken((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
        }
        if (context.testExpression("PublicKey", targetDepth))
        {
          context.nextToken();
          getParametersForImportResult.setPublicKey((ByteBuffer)context.getUnmarshaller(ByteBuffer.class).unmarshall(context));
        }
        if (context.testExpression("ParametersValidTo", targetDepth))
        {
          context.nextToken();
          getParametersForImportResult.setParametersValidTo(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return getParametersForImportResult;
  }
  
  public static GetParametersForImportResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetParametersForImportResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetParametersForImportResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */