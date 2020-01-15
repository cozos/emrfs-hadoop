package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteRolePermissionsBoundaryResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$34
  implements Callable<DeleteRolePermissionsBoundaryResult>
{
  AmazonIdentityManagementAsyncClient$34(AmazonIdentityManagementAsyncClient this$0, DeleteRolePermissionsBoundaryRequest paramDeleteRolePermissionsBoundaryRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteRolePermissionsBoundaryResult call()
    throws Exception
  {
    DeleteRolePermissionsBoundaryResult result = null;
    try
    {
      result = this$0.executeDeleteRolePermissionsBoundary(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.34
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */