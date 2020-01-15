package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CloudHsmClusterNotActiveException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.EnhancedJsonErrorUnmarshaller;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.core.JsonToken;

public class CloudHsmClusterNotActiveExceptionUnmarshaller
  extends EnhancedJsonErrorUnmarshaller
{
  private static CloudHsmClusterNotActiveExceptionUnmarshaller instance;
  
  private CloudHsmClusterNotActiveExceptionUnmarshaller()
  {
    super(CloudHsmClusterNotActiveException.class, "CloudHsmClusterNotActiveException");
  }
  
  public CloudHsmClusterNotActiveException unmarshallFromContext(JsonUnmarshallerContext context)
    throws Exception
  {
    CloudHsmClusterNotActiveException cloudHsmClusterNotActiveException = new CloudHsmClusterNotActiveException(null);
    
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
      if ((token != JsonToken.FIELD_NAME) && (token != JsonToken.START_OBJECT) && 
        ((token == JsonToken.END_ARRAY) || (token == JsonToken.END_OBJECT)) && 
        ((context.getLastParsedParentElement() == null) || (context.getLastParsedParentElement().equals(currentParentElement))) && 
        (context.getCurrentDepth() <= originalDepth)) {
        break;
      }
      token = context.nextToken();
    }
    return cloudHsmClusterNotActiveException;
  }
  
  public static CloudHsmClusterNotActiveExceptionUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new CloudHsmClusterNotActiveExceptionUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.CloudHsmClusterNotActiveExceptionUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */