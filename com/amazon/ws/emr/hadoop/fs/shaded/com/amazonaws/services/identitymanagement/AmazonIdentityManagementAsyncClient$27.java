package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteGroupPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$27
  implements Callable<DeleteGroupPolicyResult>
{
  AmazonIdentityManagementAsyncClient$27(AmazonIdentityManagementAsyncClient this$0, DeleteGroupPolicyRequest paramDeleteGroupPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteGroupPolicyResult call()
    throws Exception
  {
    DeleteGroupPolicyResult result = null;
    try
    {
      result = this$0.executeDeleteGroupPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.27
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */