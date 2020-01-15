package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedRolePoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedRolePoliciesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$81
  implements Callable<ListAttachedRolePoliciesResult>
{
  AmazonIdentityManagementAsyncClient$81(AmazonIdentityManagementAsyncClient this$0, ListAttachedRolePoliciesRequest paramListAttachedRolePoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListAttachedRolePoliciesResult call()
    throws Exception
  {
    ListAttachedRolePoliciesResult result = null;
    try
    {
      result = this$0.executeListAttachedRolePolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.81
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */