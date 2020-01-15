package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForPrincipalPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForPrincipalPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$58
  implements Callable<GetContextKeysForPrincipalPolicyResult>
{
  AmazonIdentityManagementAsyncClient$58(AmazonIdentityManagementAsyncClient this$0, GetContextKeysForPrincipalPolicyRequest paramGetContextKeysForPrincipalPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetContextKeysForPrincipalPolicyResult call()
    throws Exception
  {
    GetContextKeysForPrincipalPolicyResult result = null;
    try
    {
      result = this$0.executeGetContextKeysForPrincipalPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.58
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */