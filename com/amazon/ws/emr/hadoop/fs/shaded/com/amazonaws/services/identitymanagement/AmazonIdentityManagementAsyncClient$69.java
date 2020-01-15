package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRolePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetRolePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$69
  implements Callable<GetRolePolicyResult>
{
  AmazonIdentityManagementAsyncClient$69(AmazonIdentityManagementAsyncClient this$0, GetRolePolicyRequest paramGetRolePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetRolePolicyResult call()
    throws Exception
  {
    GetRolePolicyResult result = null;
    try
    {
      result = this$0.executeGetRolePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.69
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */