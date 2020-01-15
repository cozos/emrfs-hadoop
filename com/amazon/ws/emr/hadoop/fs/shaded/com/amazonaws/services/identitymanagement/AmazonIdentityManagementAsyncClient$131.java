package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleDescriptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateRoleDescriptionResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$131
  implements Callable<UpdateRoleDescriptionResult>
{
  AmazonIdentityManagementAsyncClient$131(AmazonIdentityManagementAsyncClient this$0, UpdateRoleDescriptionRequest paramUpdateRoleDescriptionRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateRoleDescriptionResult call()
    throws Exception
  {
    UpdateRoleDescriptionResult result = null;
    try
    {
      result = this$0.executeUpdateRoleDescription(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.131
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */