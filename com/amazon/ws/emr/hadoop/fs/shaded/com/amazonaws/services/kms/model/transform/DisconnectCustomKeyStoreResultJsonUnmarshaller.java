package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DisconnectCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class DisconnectCustomKeyStoreResultJsonUnmarshaller
  implements Unmarshaller<DisconnectCustomKeyStoreResult, JsonUnmarshallerContext>
{
  private static DisconnectCustomKeyStoreResultJsonUnmarshaller instance;
  
  public DisconnectCustomKeyStoreResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DisconnectCustomKeyStoreResult disconnectCustomKeyStoreResult = new DisconnectCustomKeyStoreResult();
    
    return disconnectCustomKeyStoreResult;
  }
  
  public static DisconnectCustomKeyStoreResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DisconnectCustomKeyStoreResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DisconnectCustomKeyStoreResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */