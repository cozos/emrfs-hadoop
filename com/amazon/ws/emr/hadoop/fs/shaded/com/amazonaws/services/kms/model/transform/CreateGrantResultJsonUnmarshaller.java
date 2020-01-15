package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateGrantResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CreateGrantResultJsonUnmarshaller
  implements Unmarshaller<CreateGrantResult, JsonUnmarshallerContext>
{
  private static CreateGrantResultJsonUnmarshaller instance;
  
  public CreateGrantResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    CreateGrantResult createGrantResult = new CreateGrantResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return createGrantResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("GrantToken", targetDepth))
        {
          context.nextToken();
          createGrantResult.setGrantToken((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("GrantId", targetDepth))
        {
          context.nextToken();
          createGrantResult.setGrantId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return createGrantResult;
  }
  
  public static CreateGrantResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CreateGrantResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CreateGrantResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */