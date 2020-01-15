package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateGroupResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$127
  implements Callable<UpdateGroupResult>
{
  AmazonIdentityManagementAsyncClient$127(AmazonIdentityManagementAsyncClient this$0, UpdateGroupRequest paramUpdateGroupRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateGroupResult call()
    throws Exception
  {
    UpdateGroupResult result = null;
    try
    {
      result = this$0.executeUpdateGroup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.127
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */