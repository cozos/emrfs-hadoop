package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPoliciesGrantingServiceAccessResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$92
  implements Callable<ListPoliciesGrantingServiceAccessResult>
{
  AmazonIdentityManagementAsyncClient$92(AmazonIdentityManagementAsyncClient this$0, ListPoliciesGrantingServiceAccessRequest paramListPoliciesGrantingServiceAccessRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListPoliciesGrantingServiceAccessResult call()
    throws Exception
  {
    ListPoliciesGrantingServiceAccessResult result = null;
    try
    {
      result = this$0.executeListPoliciesGrantingServiceAccess(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.92
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */