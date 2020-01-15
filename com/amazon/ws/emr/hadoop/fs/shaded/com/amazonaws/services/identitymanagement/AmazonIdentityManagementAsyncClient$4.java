package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AttachGroupPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$4
  implements Callable<AttachGroupPolicyResult>
{
  AmazonIdentityManagementAsyncClient$4(AmazonIdentityManagementAsyncClient this$0, AttachGroupPolicyRequest paramAttachGroupPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public AttachGroupPolicyResult call()
    throws Exception
  {
    AttachGroupPolicyResult result = null;
    try
    {
      result = this$0.executeAttachGroupPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */