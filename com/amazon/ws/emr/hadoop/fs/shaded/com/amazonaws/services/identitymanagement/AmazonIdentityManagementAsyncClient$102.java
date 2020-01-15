package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUserPoliciesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$102
  implements Callable<ListUserPoliciesResult>
{
  AmazonIdentityManagementAsyncClient$102(AmazonIdentityManagementAsyncClient this$0, ListUserPoliciesRequest paramListUserPoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListUserPoliciesResult call()
    throws Exception
  {
    ListUserPoliciesResult result = null;
    try
    {
      result = this$0.executeListUserPolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.102
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */