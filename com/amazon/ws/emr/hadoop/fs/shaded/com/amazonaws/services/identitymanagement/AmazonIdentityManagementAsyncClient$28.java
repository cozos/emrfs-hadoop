package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteInstanceProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$28
  implements Callable<DeleteInstanceProfileResult>
{
  AmazonIdentityManagementAsyncClient$28(AmazonIdentityManagementAsyncClient this$0, DeleteInstanceProfileRequest paramDeleteInstanceProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteInstanceProfileResult call()
    throws Exception
  {
    DeleteInstanceProfileResult result = null;
    try
    {
      result = this$0.executeDeleteInstanceProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.28
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */