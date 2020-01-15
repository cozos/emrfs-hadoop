package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachUserPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$48
  implements Callable<DetachUserPolicyResult>
{
  AmazonIdentityManagementAsyncClient$48(AmazonIdentityManagementAsyncClient this$0, DetachUserPolicyRequest paramDetachUserPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DetachUserPolicyResult call()
    throws Exception
  {
    DetachUserPolicyResult result = null;
    try
    {
      result = this$0.executeDetachUserPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.48
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */