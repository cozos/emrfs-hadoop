package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$66
  implements Callable<GetPolicyResult>
{
  AmazonIdentityManagementAsyncClient$66(AmazonIdentityManagementAsyncClient this$0, GetPolicyRequest paramGetPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetPolicyResult call()
    throws Exception
  {
    GetPolicyResult result = null;
    try
    {
      result = this$0.executeGetPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.66
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */