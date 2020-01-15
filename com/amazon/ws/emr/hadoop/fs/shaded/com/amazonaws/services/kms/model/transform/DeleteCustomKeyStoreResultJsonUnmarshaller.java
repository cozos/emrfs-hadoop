package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteCustomKeyStoreResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.JsonUnmarshallerContext;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.transform.Unmarshaller;

public class DeleteCustomKeyStoreResultJsonUnmarshaller
  implements Unmarshaller<DeleteCustomKeyStoreResult, JsonUnmarshallerContext>
{
  private static DeleteCustomKeyStoreResultJsonUnmarshaller instance;
  
  public DeleteCustomKeyStoreResult unmarshall(JsonUnmarshallerContext context)
    throws Exception
  {
    DeleteCustomKeyStoreResult deleteCustomKeyStoreResult = new DeleteCustomKeyStoreResult();
    
    return deleteCustomKeyStoreResult;
  }
  
  public static DeleteCustomKeyStoreResultJsonUnmarshaller getInstance()
  {
    if (instance == null) {
      instance = new DeleteCustomKeyStoreResultJsonUnmarshaller();
    }
    return instance;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.transform.DeleteCustomKeyStoreResultJsonUnmarshaller
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */