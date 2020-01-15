package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.KerberosAttributes;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class KerberosAttributesJsonUnmarshaller
  implements Unmarshaller<KerberosAttributes, JsonUnmarshallerContext>
{
  private static KerberosAttributesJsonUnmarshaller instance;
  
  public KerberosAttributes unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    KerberosAttributes kerberosAttributes = new KerberosAttributes();
    
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
        if (context.testExpression("Realm", targetDepth))
        {
          context.nextToken();
          kerberosAttributes.setRealm((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("KdcAdminPassword", targetDepth))
        {
          context.nextToken();
          kerberosAttributes.setKdcAdminPassword((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("CrossRealmTrustPrincipalPassword", targetDepth))
        {
          context.nextToken();
          kerberosAttributes.setCrossRealmTrustPrincipalPassword((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ADDomainJoinUser", targetDepth))
        {
          context.nextToken();
          kerberosAttributes.setADDomainJoinUser((String)context.getUnmarshaller(String.class).unmarshall(context));
        }
        if (context.testExpression("ADDomainJoinPassword", targetDepth))
        {
          context.nextToken();
          kerberosAttributes.setADDomainJoinPassword((String)context.getUnmarshaller(String.class).unmarshall(context));
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
    return kerberosAttributes;
  }
  
  public static KerberosAttributesJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new KerberosAttributesJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.transform.KerberosAttributesJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */