package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateDataKeyResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$19
  implements Callable<GenerateDataKeyResult>
{
  AWSKMSAsyncClient$19(AWSKMSAsyncClient this$0, GenerateDataKeyRequest paramGenerateDataKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GenerateDataKeyResult call()
    throws Exception
  {
    GenerateDataKeyResult result = null;
    try
    {
      result = this$0.executeGenerateDataKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */