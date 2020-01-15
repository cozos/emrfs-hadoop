package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateRandomRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.GenerateRandomResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$21
  implements Callable<GenerateRandomResult>
{
  AWSKMSAsyncClient$21(AWSKMSAsyncClient this$0, GenerateRandomRequest paramGenerateRandomRequest, AsyncHandler paramAsyncHandler) {}
  
  public GenerateRandomResult call()
    throws Exception
  {
    GenerateRandomResult result = null;
    try
    {
      result = this$0.executeGenerateRandom(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */