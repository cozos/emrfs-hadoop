package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RetireGrantRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RetireGrantResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$34
  implements Callable<RetireGrantResult>
{
  AWSKMSAsyncClient$34(AWSKMSAsyncClient this$0, RetireGrantRequest paramRetireGrantRequest, AsyncHandler paramAsyncHandler) {}
  
  public RetireGrantResult call()
    throws Exception
  {
    RetireGrantResult result = null;
    try
    {
      result = this$0.executeRetireGrant(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.34
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */