package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class UpdateCustomKeyStoreResultJsonUnmarshaller
  implements Unmarshaller<UpdateCustomKeyStoreResult, JsonUnmarshallerContext>
{
  private static UpdateCustomKeyStoreResultJsonUnmarshaller instance;
  
  public UpdateCustomKeyStoreResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    UpdateCustomKeyStoreResult updateCustomKeyStoreResult = new UpdateCustomKeyStoreResult();
    
    return updateCustomKeyStoreResult;
  }
  
  public static UpdateCustomKeyStoreResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new UpdateCustomKeyStoreResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.UpdateCustomKeyStoreResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */