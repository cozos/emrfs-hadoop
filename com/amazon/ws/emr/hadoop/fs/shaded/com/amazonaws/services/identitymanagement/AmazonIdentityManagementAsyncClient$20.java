package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateUserResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$20
  implements Callable<CreateUserResult>
{
  AmazonIdentityManagementAsyncClient$20(AmazonIdentityManagementAsyncClient this$0, CreateUserRequest paramCreateUserRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateUserResult call()
    throws Exception
  {
    CreateUserResult result = null;
    try
    {
      result = this$0.executeCreateUser(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */