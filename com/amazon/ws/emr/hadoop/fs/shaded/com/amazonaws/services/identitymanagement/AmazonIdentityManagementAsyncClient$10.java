package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateGroupResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$10
  implements Callable<CreateGroupResult>
{
  AmazonIdentityManagementAsyncClient$10(AmazonIdentityManagementAsyncClient this$0, CreateGroupRequest paramCreateGroupRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateGroupResult call()
    throws Exception
  {
    CreateGroupResult result = null;
    try
    {
      result = this$0.executeCreateGroup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.10
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */