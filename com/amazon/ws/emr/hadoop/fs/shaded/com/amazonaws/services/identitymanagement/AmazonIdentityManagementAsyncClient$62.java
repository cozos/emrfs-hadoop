package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetInstanceProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$62
  implements Callable<GetInstanceProfileResult>
{
  AmazonIdentityManagementAsyncClient$62(AmazonIdentityManagementAsyncClient this$0, GetInstanceProfileRequest paramGetInstanceProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetInstanceProfileResult call()
    throws Exception
  {
    GetInstanceProfileResult result = null;
    try
    {
      result = this$0.executeGetInstanceProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.62
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */