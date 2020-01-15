package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CustomKeyStoresListEntry;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CustomKeyStoresListEntryJsonUnmarshaller
  implements Unmarshaller<CustomKeyStoresListEntry, JsonUnmarshallerContext>
{
  private static CustomKeyStoresListEntryJsonUnmarshaller instance;
  
  public CustomKeyStoresListEntry unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    CustomKeyStoresListEntry customKeyStoresListEntry = new CustomKeyStoresListEntry();
    
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
        if (context.testExpression("CustomKeyStoreId", targetDepth))
        {
          context.nextToken();
          customKeyStoresListEntry.setCustomKeyStoreId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CustomKeyStoreName", targetDepth))
        {
          context.nextToken();
          customKeyStoresListEntry.setCustomKeyStoreName((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CloudHsmClusterId", targetDepth))
        {
          context.nextToken();
          customKeyStoresListEntry.setCloudHsmClusterId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("TrustAnchorCertificate", targetDepth))
        {
          context.nextToken();
          customKeyStoresListEntry.setTrustAnchorCertificate((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ConnectionState", targetDepth))
        {
          context.nextToken();
          customKeyStoresListEntry.setConnectionState((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ConnectionErrorCode", targetDepth))
        {
          context.nextToken();
          customKeyStoresListEntry.setConnectionErrorCode((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationDate", targetDepth))
        {
          context.nextToken();
          customKeyStoresListEntry.setCreationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
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
    return customKeyStoresListEntry;
  }
  
  public static CustomKeyStoresListEntryJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CustomKeyStoresListEntryJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CustomKeyStoresListEntryJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */