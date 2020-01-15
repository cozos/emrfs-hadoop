package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachRolePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$47
  implements Callable<DetachRolePolicyResult>
{
  AmazonIdentityManagementAsyncClient$47(AmazonIdentityManagementAsyncClient this$0, DetachRolePolicyRequest paramDetachRolePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DetachRolePolicyResult call()
    throws Exception
  {
    DetachRolePolicyResult result = null;
    try
    {
      result = this$0.executeDetachRolePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.47
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */