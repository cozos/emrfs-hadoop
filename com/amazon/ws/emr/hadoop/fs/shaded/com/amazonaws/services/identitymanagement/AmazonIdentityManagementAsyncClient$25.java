package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteAccountPasswordPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$25
  implements Callable<DeleteAccountPasswordPolicyResult>
{
  AmazonIdentityManagementAsyncClient$25(AmazonIdentityManagementAsyncClient this$0, DeleteAccountPasswordPolicyRequest paramDeleteAccountPasswordPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteAccountPasswordPolicyResult call()
    throws Exception
  {
    DeleteAccountPasswordPolicyResult result = null;
    try
    {
      result = this$0.executeDeleteAccountPasswordPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.25
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */