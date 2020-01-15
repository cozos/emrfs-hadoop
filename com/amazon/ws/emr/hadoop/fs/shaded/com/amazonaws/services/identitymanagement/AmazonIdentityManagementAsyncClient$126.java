package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAssumeRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAssumeRolePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$126
  implements Callable<UpdateAssumeRolePolicyResult>
{
  AmazonIdentityManagementAsyncClient$126(AmazonIdentityManagementAsyncClient this$0, UpdateAssumeRolePolicyRequest paramUpdateAssumeRolePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateAssumeRolePolicyResult call()
    throws Exception
  {
    UpdateAssumeRolePolicyResult result = null;
    try
    {
      result = this$0.executeUpdateAssumeRolePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.126
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */