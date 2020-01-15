package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$130
  implements Callable<UpdateRoleResult>
{
  AmazonIdentityManagementAsyncClient$130(AmazonIdentityManagementAsyncClient this$0, UpdateRoleRequest paramUpdateRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateRoleResult call()
    throws Exception
  {
    UpdateRoleResult result = null;
    try
    {
      result = this$0.executeUpdateRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.130
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */