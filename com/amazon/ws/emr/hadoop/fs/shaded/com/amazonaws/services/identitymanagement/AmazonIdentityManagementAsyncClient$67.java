package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyVersionResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$67
  implements Callable<GetPolicyVersionResult>
{
  AmazonIdentityManagementAsyncClient$67(AmazonIdentityManagementAsyncClient this$0, GetPolicyVersionRequest paramGetPolicyVersionRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetPolicyVersionResult call()
    throws Exception
  {
    GetPolicyVersionResult result = null;
    try
    {
      result = this$0.executeGetPolicyVersion(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.67
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */