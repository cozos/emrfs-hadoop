package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateInstanceProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$11
  implements Callable<CreateInstanceProfileResult>
{
  AmazonIdentityManagementAsyncClient$11(AmazonIdentityManagementAsyncClient this$0, CreateInstanceProfileRequest paramCreateInstanceProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateInstanceProfileResult call()
    throws Exception
  {
    CreateInstanceProfileResult result = null;
    try
    {
      result = this$0.executeCreateInstanceProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */