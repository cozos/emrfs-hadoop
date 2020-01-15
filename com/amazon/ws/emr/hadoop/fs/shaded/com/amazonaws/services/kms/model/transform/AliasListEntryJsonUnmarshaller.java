package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.AliasListEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class AliasListEntryJsonUnmarshaller
  implements Unmarshaller<AliasListEntry, JsonUnmarshallerContext>
{
  private static AliasListEntryJsonUnmarshaller instance;
  
  public AliasListEntry unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    AliasListEntry aliasListEntry = new AliasListEntry();
    
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
        if (context.testExpression("AliasName", targetDepth))
        {
          context.nextToken();
          aliasListEntry.setAliasName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("AliasArn", targetDepth))
        {
          context.nextToken();
          aliasListEntry.setAliasArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TargetKeyId", targetDepth))
        {
          context.nextToken();
          aliasListEntry.setTargetKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return aliasListEntry;
  }
  
  public static AliasListEntryJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new AliasListEntryJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.AliasListEntryJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */