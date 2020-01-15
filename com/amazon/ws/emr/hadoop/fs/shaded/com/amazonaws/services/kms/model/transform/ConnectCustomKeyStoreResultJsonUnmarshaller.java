package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ConnectCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class ConnectCustomKeyStoreResultJsonUnmarshaller
  implements Unmarshaller<ConnectCustomKeyStoreResult, JsonUnmarshallerContext>
{
  private static ConnectCustomKeyStoreResultJsonUnmarshaller instance;
  
  public ConnectCustomKeyStoreResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    ConnectCustomKeyStoreResult connectCustomKeyStoreResult = new ConnectCustomKeyStoreResult();
    
    return connectCustomKeyStoreResult;
  }
  
  public static ConnectCustomKeyStoreResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new ConnectCustomKeyStoreResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.ConnectCustomKeyStoreResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */