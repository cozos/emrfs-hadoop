package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceLinkedRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServiceLinkedRoleResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$39
  implements Callable<DeleteServiceLinkedRoleResult>
{
  AmazonIdentityManagementAsyncClient$39(AmazonIdentityManagementAsyncClient this$0, DeleteServiceLinkedRoleRequest paramDeleteServiceLinkedRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteServiceLinkedRoleResult call()
    throws Exception
  {
    DeleteServiceLinkedRoleResult result = null;
    try
    {
      result = this$0.executeDeleteServiceLinkedRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.39
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */