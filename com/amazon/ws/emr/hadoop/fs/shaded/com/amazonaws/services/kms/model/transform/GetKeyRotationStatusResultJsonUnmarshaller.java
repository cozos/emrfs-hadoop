package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GetKeyRotationStatusResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class GetKeyRotationStatusResultJsonUnmarshaller
  implements Unmarshaller<GetKeyRotationStatusResult, JsonUnmarshallerContext>
{
  private static GetKeyRotationStatusResultJsonUnmarshaller instance;
  
  public GetKeyRotationStatusResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    GetKeyRotationStatusResult getKeyRotationStatusResult = new GetKeyRotationStatusResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return getKeyRotationStatusResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("KeyRotationEnabled", targetDepth))
        {
          context.nextToken();
          getKeyRotationStatusResult.setKeyRotationEnabled((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return getKeyRotationStatusResult;
  }
  
  public static GetKeyRotationStatusResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new GetKeyRotationStatusResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.GetKeyRotationStatusResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */