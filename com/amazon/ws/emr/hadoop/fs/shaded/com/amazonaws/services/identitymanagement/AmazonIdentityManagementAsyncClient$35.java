package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$35
  implements Callable<DeleteRolePolicyResult>
{
  AmazonIdentityManagementAsyncClient$35(AmazonIdentityManagementAsyncClient this$0, DeleteRolePolicyRequest paramDeleteRolePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteRolePolicyResult call()
    throws Exception
  {
    DeleteRolePolicyResult result = null;
    try
    {
      result = this$0.executeDeleteRolePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.35
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */