package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutRolePermissionsBoundaryResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$107
  implements Callable<PutRolePermissionsBoundaryResult>
{
  AmazonIdentityManagementAsyncClient$107(AmazonIdentityManagementAsyncClient this$0, PutRolePermissionsBoundaryRequest paramPutRolePermissionsBoundaryRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutRolePermissionsBoundaryResult call()
    throws Exception
  {
    PutRolePermissionsBoundaryResult result = null;
    try
    {
      result = this$0.executePutRolePermissionsBoundary(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.107
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */