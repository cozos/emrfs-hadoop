package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteUserResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$42
  implements Callable<DeleteUserResult>
{
  AmazonIdentityManagementAsyncClient$42(AmazonIdentityManagementAsyncClient this$0, DeleteUserRequest paramDeleteUserRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteUserResult call()
    throws Exception
  {
    DeleteUserResult result = null;
    try
    {
      result = this$0.executeDeleteUser(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.42
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */