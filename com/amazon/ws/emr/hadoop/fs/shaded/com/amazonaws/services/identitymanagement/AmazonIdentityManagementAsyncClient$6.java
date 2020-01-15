package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachUserPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$6
  implements Callable<AttachUserPolicyResult>
{
  AmazonIdentityManagementAsyncClient$6(AmazonIdentityManagementAsyncClient this$0, AttachUserPolicyRequest paramAttachUserPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public AttachUserPolicyResult call()
    throws Exception
  {
    AttachUserPolicyResult result = null;
    try
    {
      result = this$0.executeAttachUserPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */