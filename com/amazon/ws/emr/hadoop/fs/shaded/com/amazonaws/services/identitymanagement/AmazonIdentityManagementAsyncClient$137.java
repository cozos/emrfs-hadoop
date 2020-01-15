package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateUserResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$137
  implements Callable<UpdateUserResult>
{
  AmazonIdentityManagementAsyncClient$137(AmazonIdentityManagementAsyncClient this$0, UpdateUserRequest paramUpdateUserRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateUserResult call()
    throws Exception
  {
    UpdateUserResult result = null;
    try
    {
      result = this$0.executeUpdateUser(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.137
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */