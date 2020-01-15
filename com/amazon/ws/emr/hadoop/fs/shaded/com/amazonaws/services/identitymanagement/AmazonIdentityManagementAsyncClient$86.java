package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsForUserRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListGroupsForUserResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$86
  implements Callable<ListGroupsForUserResult>
{
  AmazonIdentityManagementAsyncClient$86(AmazonIdentityManagementAsyncClient this$0, ListGroupsForUserRequest paramListGroupsForUserRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListGroupsForUserResult call()
    throws Exception
  {
    ListGroupsForUserResult result = null;
    try
    {
      result = this$0.executeListGroupsForUser(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.86
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */