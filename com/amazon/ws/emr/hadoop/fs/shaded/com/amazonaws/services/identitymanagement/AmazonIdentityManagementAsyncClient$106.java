package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutGroupPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutGroupPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$106
  implements Callable<PutGroupPolicyResult>
{
  AmazonIdentityManagementAsyncClient$106(AmazonIdentityManagementAsyncClient this$0, PutGroupPolicyRequest paramPutGroupPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutGroupPolicyResult call()
    throws Exception
  {
    PutGroupPolicyResult result = null;
    try
    {
      result = this$0.executePutGroupPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.106
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */