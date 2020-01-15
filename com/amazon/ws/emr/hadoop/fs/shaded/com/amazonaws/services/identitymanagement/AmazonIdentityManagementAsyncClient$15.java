package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreatePolicyVersionResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$15
  implements Callable<CreatePolicyVersionResult>
{
  AmazonIdentityManagementAsyncClient$15(AmazonIdentityManagementAsyncClient this$0, CreatePolicyVersionRequest paramCreatePolicyVersionRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreatePolicyVersionResult call()
    throws Exception
  {
    CreatePolicyVersionResult result = null;
    try
    {
      result = this$0.executeCreatePolicyVersion(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.15
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */