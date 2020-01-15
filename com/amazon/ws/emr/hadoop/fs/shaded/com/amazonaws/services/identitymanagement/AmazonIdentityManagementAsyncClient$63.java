package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetLoginProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$63
  implements Callable<GetLoginProfileResult>
{
  AmazonIdentityManagementAsyncClient$63(AmazonIdentityManagementAsyncClient this$0, GetLoginProfileRequest paramGetLoginProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetLoginProfileResult call()
    throws Exception
  {
    GetLoginProfileResult result = null;
    try
    {
      result = this$0.executeGetLoginProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.63
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */