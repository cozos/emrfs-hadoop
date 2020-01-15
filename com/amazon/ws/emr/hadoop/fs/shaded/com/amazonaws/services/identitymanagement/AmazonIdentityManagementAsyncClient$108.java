package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$108
  implements Callable<PutRolePolicyResult>
{
  AmazonIdentityManagementAsyncClient$108(AmazonIdentityManagementAsyncClient this$0, PutRolePolicyRequest paramPutRolePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutRolePolicyResult call()
    throws Exception
  {
    PutRolePolicyResult result = null;
    try
    {
      result = this$0.executePutRolePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.108
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */