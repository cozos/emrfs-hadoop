package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserPermissionsBoundaryResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$43
  implements Callable<DeleteUserPermissionsBoundaryResult>
{
  AmazonIdentityManagementAsyncClient$43(AmazonIdentityManagementAsyncClient this$0, DeleteUserPermissionsBoundaryRequest paramDeleteUserPermissionsBoundaryRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteUserPermissionsBoundaryResult call()
    throws Exception
  {
    DeleteUserPermissionsBoundaryResult result = null;
    try
    {
      result = this$0.executeDeleteUserPermissionsBoundary(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.43
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */