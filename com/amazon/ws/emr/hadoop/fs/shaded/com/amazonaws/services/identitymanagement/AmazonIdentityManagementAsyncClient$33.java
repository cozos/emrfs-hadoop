package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRoleResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$33
  implements Callable<DeleteRoleResult>
{
  AmazonIdentityManagementAsyncClient$33(AmazonIdentityManagementAsyncClient this$0, DeleteRoleRequest paramDeleteRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteRoleResult call()
    throws Exception
  {
    DeleteRoleResult result = null;
    try
    {
      result = this$0.executeDeleteRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.33
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */