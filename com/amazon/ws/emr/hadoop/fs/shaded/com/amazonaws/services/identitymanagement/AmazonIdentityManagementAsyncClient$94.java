package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolePoliciesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListRolePoliciesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$94
  implements Callable<ListRolePoliciesResult>
{
  AmazonIdentityManagementAsyncClient$94(AmazonIdentityManagementAsyncClient this$0, ListRolePoliciesRequest paramListRolePoliciesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListRolePoliciesResult call()
    throws Exception
  {
    ListRolePoliciesResult result = null;
    try
    {
      result = this$0.executeListRolePolicies(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.94
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */