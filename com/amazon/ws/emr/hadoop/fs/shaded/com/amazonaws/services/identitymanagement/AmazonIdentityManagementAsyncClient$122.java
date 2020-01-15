package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UntagRoleResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$122
  implements Callable<UntagRoleResult>
{
  AmazonIdentityManagementAsyncClient$122(AmazonIdentityManagementAsyncClient this$0, UntagRoleRequest paramUntagRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public UntagRoleResult call()
    throws Exception
  {
    UntagRoleResult result = null;
    try
    {
      result = this$0.executeUntagRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.122
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */