package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$77
  implements Callable<GetUserPolicyResult>
{
  AmazonIdentityManagementAsyncClient$77(AmazonIdentityManagementAsyncClient this$0, GetUserPolicyRequest paramGetUserPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetUserPolicyResult call()
    throws Exception
  {
    GetUserPolicyResult result = null;
    try
    {
      result = this$0.executeGetUserPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.77
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */