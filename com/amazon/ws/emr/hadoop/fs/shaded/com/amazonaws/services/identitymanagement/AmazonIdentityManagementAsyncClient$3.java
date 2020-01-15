package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddUserToGroupResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$3
  implements Callable<AddUserToGroupResult>
{
  AmazonIdentityManagementAsyncClient$3(AmazonIdentityManagementAsyncClient this$0, AddUserToGroupRequest paramAddUserToGroupRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddUserToGroupResult call()
    throws Exception
  {
    AddUserToGroupResult result = null;
    try
    {
      result = this$0.executeAddUserToGroup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */