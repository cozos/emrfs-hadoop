package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ImportKeyMaterialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ImportKeyMaterialResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$25
  implements Callable<ImportKeyMaterialResult>
{
  AWSKMSAsyncClient$25(AWSKMSAsyncClient this$0, ImportKeyMaterialRequest paramImportKeyMaterialRequest, AsyncHandler paramAsyncHandler) {}
  
  public ImportKeyMaterialResult call()
    throws Exception
  {
    ImportKeyMaterialResult result = null;
    try
    {
      result = this$0.executeImportKeyMaterial(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */