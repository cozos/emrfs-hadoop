package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DetachGroupPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$46
  implements Callable<DetachGroupPolicyResult>
{
  AmazonIdentityManagementAsyncClient$46(AmazonIdentityManagementAsyncClient this$0, DetachGroupPolicyRequest paramDetachGroupPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DetachGroupPolicyResult call()
    throws Exception
  {
    DetachGroupPolicyResult result = null;
    try
    {
      result = this$0.executeDetachGroupPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.46
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */