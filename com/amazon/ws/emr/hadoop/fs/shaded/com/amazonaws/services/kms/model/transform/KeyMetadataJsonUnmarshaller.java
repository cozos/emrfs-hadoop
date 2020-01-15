package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.KeyMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class KeyMetadataJsonUnmarshaller
  implements Unmarshaller<KeyMetadata, JsonUnmarshallerContext>
{
  private static KeyMetadataJsonUnmarshaller instance;
  
  public KeyMetadata unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    KeyMetadata keyMetadata = new KeyMetadata();
    
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
        if (context.testExpression("AWSAccountId", targetDepth))
        {
          context.nextToken();
          keyMetadata.setAWSAccountId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeyId", targetDepth))
        {
          context.nextToken();
          keyMetadata.setKeyId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("Arn", targetDepth))
        {
          context.nextToken();
          keyMetadata.setArn((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CreationDate", targetDepth))
        {
          context.nextToken();
          keyMetadata.setCreationDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("Enabled", targetDepth))
        {
          context.nextToken();
          keyMetadata.setEnabled((Boolean)context.getUnmarshaller(Boolean.class).unmarshall(context));
        }
        if (context.testExpression("Description", targetDepth))
        {
          context.nextToken();
          keyMetadata.setDescription((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeyUsage", targetDepth))
        {
          context.nextToken();
          keyMetadata.setKeyUsage((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeyState", targetDepth))
        {
          context.nextToken();
          keyMetadata.setKeyState((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("DeletionDate", targetDepth))
        {
          context.nextToken();
          keyMetadata.setDeletionDate(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("ValidTo", targetDepth))
        {
          context.nextToken();
          keyMetadata.setValidTo(SimpleTypeJsonUnmarshallers.DateJsonUnmarshallerFactory.getInstance("unixTimestamp").unmarshall(context));
        }
        if (context.testExpression("Origin", targetDepth))
        {
          context.nextToken();
          keyMetadata.setOrigin((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CustomKeyStoreId", targetDepth))
        {
          context.nextToken();
          keyMetadata.setCustomKeyStoreId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CloudHsmClusterId", targetDepth))
        {
          context.nextToken();
          keyMetadata.setCloudHsmClusterId((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ExpirationModel", targetDepth))
        {
          context.nextToken();
          keyMetadata.setExpirationModel((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KeyManager", targetDepth))
        {
          context.nextToken();
          keyMetadata.setKeyManager((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return keyMetadata;
  }
  
  public static KeyMetadataJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new KeyMetadataJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.KeyMetadataJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */