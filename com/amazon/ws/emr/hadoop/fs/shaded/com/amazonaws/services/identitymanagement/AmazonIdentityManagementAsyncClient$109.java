package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPermissionsBoundaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.PutUserPermissionsBoundaryResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$109
  implements Callable<PutUserPermissionsBoundaryResult>
{
  AmazonIdentityManagementAsyncClient$109(AmazonIdentityManagementAsyncClient this$0, PutUserPermissionsBoundaryRequest paramPutUserPermissionsBoundaryRequest, AsyncHandler paramAsyncHandler) {}
  
  public PutUserPermissionsBoundaryResult call()
    throws Exception
  {
    PutUserPermissionsBoundaryResult result = null;
    try
    {
      result = this$0.executePutUserPermissionsBoundary(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.109
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */