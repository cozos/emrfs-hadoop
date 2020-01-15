package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.SSEDescription;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class SSEDescriptionJsonUnmarshaller
  implements Unmarshaller<SSEDescription, JsonUnmarshallerContext>
{
  private static SSEDescriptionJsonUnmarshaller instance;
  
  public SSEDescription unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    SSEDescription sSEDescription = new SSEDescription();
    
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
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("Status", targetDepth))
        {
          context.nextToken();
          sSEDescription.setStatus((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("SSEType", targetDepth))
        {
          context.nextToken();
          sSEDescription.setSSEType((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KMSMasterKeyArn", targetDepth))
        {
          context.nextToken();
          sSEDescription.setKMSMasterKeyArn((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return sSEDescription;
  }
  
  public static SSEDescriptionJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new SSEDescriptionJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.transform.SSEDescriptionJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */