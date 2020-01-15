package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateLoginProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateLoginProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$12
  implements Callable<CreateLoginProfileResult>
{
  AmazonIdentityManagementAsyncClient$12(AmazonIdentityManagementAsyncClient this$0, CreateLoginProfileRequest paramCreateLoginProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateLoginProfileResult call()
    throws Exception
  {
    CreateLoginProfileResult result = null;
    try
    {
      result = this$0.executeCreateLoginProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */