package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListEntitiesForPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$83
  implements Callable<ListEntitiesForPolicyResult>
{
  AmazonIdentityManagementAsyncClient$83(AmazonIdentityManagementAsyncClient this$0, ListEntitiesForPolicyRequest paramListEntitiesForPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListEntitiesForPolicyResult call()
    throws Exception
  {
    ListEntitiesForPolicyResult result = null;
    try
    {
      result = this$0.executeListEntitiesForPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.83
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */