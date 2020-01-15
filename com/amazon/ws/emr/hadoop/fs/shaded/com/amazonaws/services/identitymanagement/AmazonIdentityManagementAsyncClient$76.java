package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetUserResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$76
  implements Callable<GetUserResult>
{
  AmazonIdentityManagementAsyncClient$76(AmazonIdentityManagementAsyncClient this$0, GetUserRequest paramGetUserRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetUserResult call()
    throws Exception
  {
    GetUserResult result = null;
    try
    {
      result = this$0.executeGetUser(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.76
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */