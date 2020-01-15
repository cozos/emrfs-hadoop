package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$91
  implements Callable<ListPoliciesResult>
{
  AmazonIdentityManagementAsyncClient$91(AmazonIdentityManagementAsyncClient this$0, ListPoliciesRequest paramListPoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListPoliciesResult call()
    throws Exception
  {
    ListPoliciesResult result = null;
    try
    {
      result = this$0.executeListPolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.91
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */