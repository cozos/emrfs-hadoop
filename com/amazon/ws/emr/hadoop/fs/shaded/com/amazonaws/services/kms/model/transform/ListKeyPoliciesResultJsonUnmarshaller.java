package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeyPoliciesResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.ListUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class ListKeyPoliciesResultJsonUnmarshaller
  implements Unmarshaller<ListKeyPoliciesResult, JsonUnmarshallerContext>
{
  private static ListKeyPoliciesResultJsonUnmarshaller instance;
  
  public ListKeyPoliciesResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ListKeyPoliciesResult listKeyPoliciesResult = new ListKeyPoliciesResult();
    
    int originalDepth = context.getCurrentDepth();
    String currentParentElement = context.getCurrentParentElement();
    int targetDepth = originalDepth + 1;
    
    JsonToken token = context.getCurrentToken();
    if (token == null) {
      token = context.nextToken();
    }
    if (token == JsonToken.VALUE_NULL) {
      return listKeyPoliciesResult;
    }
    while (token != null)
    {
      if ((token == JsonToken.FIELD_NAME) || (token == JsonToken.START_OBJECT))
      {
        if (context.testExpression("PolicyNames", targetDepth))
        {
          context.nextToken();
          listKeyPoliciesResult.setPolicyNames(new ListUnmarshaller(context.getUnmarshaller(String.class)).unmarshall(context));
        }
        if (context.testExpression("NextMarker", targetDepth))
        {
          context.nextToken();
          listKeyPoliciesResult.setNextMarker((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Truncated", targetDepth))
        {
          context.nextToken();
          listKeyPoliciesResult.setTruncated((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
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
    return listKeyPoliciesResult;
  }
  
  public static ListKeyPoliciesResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ListKeyPoliciesResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ListKeyPoliciesResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */