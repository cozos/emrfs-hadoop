package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteImportedKeyMaterialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteImportedKeyMaterialResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$10
  implements Callable<DeleteImportedKeyMaterialResult>
{
  AWSKMSAsyncClient$10(AWSKMSAsyncClient this$0, DeleteImportedKeyMaterialRequest paramDeleteImportedKeyMaterialRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteImportedKeyMaterialResult call()
    throws Exception
  {
    DeleteImportedKeyMaterialResult result = null;
    try
    {
      result = this$0.executeDeleteImportedKeyMaterial(val$finalRequest);
    }
    catch (Exception ex)
    {
      if (val$asyncHandler != null) {
        val$asyncHandler.onError(ex);
      }
      throw ex;
    }
    if (val$asyncHandler != null) {
      val$asyncHandler.onSuccess(val$finalRequest, result);
    }
    return result;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */