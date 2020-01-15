package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPolicyVersionsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListPolicyVersionsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$93
  implements Callable<ListPolicyVersionsResult>
{
  AmazonIdentityManagementAsyncClient$93(AmazonIdentityManagementAsyncClient this$0, ListPolicyVersionsRequest paramListPolicyVersionsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListPolicyVersionsResult call()
    throws Exception
  {
    ListPolicyVersionsResult result = null;
    try
    {
      result = this$0.executeListPolicyVersions(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.93
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */