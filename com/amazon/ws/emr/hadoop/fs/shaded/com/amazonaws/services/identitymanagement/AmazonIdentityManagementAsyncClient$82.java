package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedUserPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedUserPoliciesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$82
  implements Callable<ListAttachedUserPoliciesResult>
{
  AmazonIdentityManagementAsyncClient$82(AmazonIdentityManagementAsyncClient this$0, ListAttachedUserPoliciesRequest paramListAttachedUserPoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListAttachedUserPoliciesResult call()
    throws Exception
  {
    ListAttachedUserPoliciesResult result = null;
    try
    {
      result = this$0.executeListAttachedUserPolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.82
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */