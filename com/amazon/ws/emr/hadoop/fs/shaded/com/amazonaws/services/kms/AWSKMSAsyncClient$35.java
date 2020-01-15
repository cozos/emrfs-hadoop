package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RevokeGrantRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.RevokeGrantResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$35
  implements Callable<RevokeGrantResult>
{
  AWSKMSAsyncClient$35(AWSKMSAsyncClient this$0, RevokeGrantRequest paramRevokeGrantRequest, AsyncHandler paramAsyncHandler) {}
  
  public RevokeGrantResult call()
    throws Exception
  {
    RevokeGrantResult result = null;
    try
    {
      result = this$0.executeRevokeGrant(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.35
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */