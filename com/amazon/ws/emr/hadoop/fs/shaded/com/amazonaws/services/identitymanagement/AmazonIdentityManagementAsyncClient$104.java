package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUsersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListUsersResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$104
  implements Callable<ListUsersResult>
{
  AmazonIdentityManagementAsyncClient$104(AmazonIdentityManagementAsyncClient this$0, ListUsersRequest paramListUsersRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListUsersResult call()
    throws Exception
  {
    ListUsersResult result = null;
    try
    {
      result = this$0.executeListUsers(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.104
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */