package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$14
  implements Callable<CreatePolicyResult>
{
  AmazonIdentityManagementAsyncClient$14(AmazonIdentityManagementAsyncClient this$0, CreatePolicyRequest paramCreatePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreatePolicyResult call()
    throws Exception
  {
    CreatePolicyResult result = null;
    try
    {
      result = this$0.executeCreatePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.14
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */