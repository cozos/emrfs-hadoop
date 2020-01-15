package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ChangePasswordRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ChangePasswordResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$7
  implements Callable<ChangePasswordResult>
{
  AmazonIdentityManagementAsyncClient$7(AmazonIdentityManagementAsyncClient this$0, ChangePasswordRequest paramChangePasswordRequest, AsyncHandler paramAsyncHandler) {}
  
  public ChangePasswordResult call()
    throws Exception
  {
    ChangePasswordResult result = null;
    try
    {
      result = this$0.executeChangePassword(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */