package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListAttachedGroupPoliciesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$80
  implements Callable<ListAttachedGroupPoliciesResult>
{
  AmazonIdentityManagementAsyncClient$80(AmazonIdentityManagementAsyncClient this$0, ListAttachedGroupPoliciesRequest paramListAttachedGroupPoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListAttachedGroupPoliciesResult call()
    throws Exception
  {
    ListAttachedGroupPoliciesResult result = null;
    try
    {
      result = this$0.executeListAttachedGroupPolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.80
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */