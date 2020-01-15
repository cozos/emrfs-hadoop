package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForCustomPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetContextKeysForCustomPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$57
  implements Callable<GetContextKeysForCustomPolicyResult>
{
  AmazonIdentityManagementAsyncClient$57(AmazonIdentityManagementAsyncClient this$0, GetContextKeysForCustomPolicyRequest paramGetContextKeysForCustomPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetContextKeysForCustomPolicyResult call()
    throws Exception
  {
    GetContextKeysForCustomPolicyResult result = null;
    try
    {
      result = this$0.executeGetContextKeysForCustomPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.57
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */