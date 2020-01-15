package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateRoleResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$16
  implements Callable<CreateRoleResult>
{
  AmazonIdentityManagementAsyncClient$16(AmazonIdentityManagementAsyncClient this$0, CreateRoleRequest paramCreateRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateRoleResult call()
    throws Exception
  {
    CreateRoleResult result = null;
    try
    {
      result = this$0.executeCreateRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.16
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */