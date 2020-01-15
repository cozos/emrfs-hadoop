package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteLoginProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$29
  implements Callable<DeleteLoginProfileResult>
{
  AmazonIdentityManagementAsyncClient$29(AmazonIdentityManagementAsyncClient this$0, DeleteLoginProfileRequest paramDeleteLoginProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteLoginProfileResult call()
    throws Exception
  {
    DeleteLoginProfileResult result = null;
    try
    {
      result = this$0.executeDeleteLoginProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.29
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */