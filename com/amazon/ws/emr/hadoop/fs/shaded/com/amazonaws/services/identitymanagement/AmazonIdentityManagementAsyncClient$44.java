package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$44
  implements Callable<DeleteUserPolicyResult>
{
  AmazonIdentityManagementAsyncClient$44(AmazonIdentityManagementAsyncClient this$0, DeleteUserPolicyRequest paramDeleteUserPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteUserPolicyResult call()
    throws Exception
  {
    DeleteUserPolicyResult result = null;
    try
    {
      result = this$0.executeDeleteUserPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.44
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */