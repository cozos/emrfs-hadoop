package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachRolePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$5
  implements Callable<AttachRolePolicyResult>
{
  AmazonIdentityManagementAsyncClient$5(AmazonIdentityManagementAsyncClient this$0, AttachRolePolicyRequest paramAttachRolePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public AttachRolePolicyResult call()
    throws Exception
  {
    AttachRolePolicyResult result = null;
    try
    {
      result = this$0.executeAttachRolePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */