package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateAccountPasswordPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$125
  implements Callable<UpdateAccountPasswordPolicyResult>
{
  AmazonIdentityManagementAsyncClient$125(AmazonIdentityManagementAsyncClient this$0, UpdateAccountPasswordPolicyRequest paramUpdateAccountPasswordPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateAccountPasswordPolicyResult call()
    throws Exception
  {
    UpdateAccountPasswordPolicyResult result = null;
    try
    {
      result = this$0.executeUpdateAccountPasswordPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.125
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */