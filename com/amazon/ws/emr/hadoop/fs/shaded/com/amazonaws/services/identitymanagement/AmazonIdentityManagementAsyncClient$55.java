package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountPasswordPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountPasswordPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$55
  implements Callable<GetAccountPasswordPolicyResult>
{
  AmazonIdentityManagementAsyncClient$55(AmazonIdentityManagementAsyncClient this$0, GetAccountPasswordPolicyRequest paramGetAccountPasswordPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetAccountPasswordPolicyResult call()
    throws Exception
  {
    GetAccountPasswordPolicyResult result = null;
    try
    {
      result = this$0.executeGetAccountPasswordPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.55
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */