package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateLoginProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$128
  implements Callable<UpdateLoginProfileResult>
{
  AmazonIdentityManagementAsyncClient$128(AmazonIdentityManagementAsyncClient this$0, UpdateLoginProfileRequest paramUpdateLoginProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateLoginProfileResult call()
    throws Exception
  {
    UpdateLoginProfileResult result = null;
    try
    {
      result = this$0.executeUpdateLoginProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.128
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */