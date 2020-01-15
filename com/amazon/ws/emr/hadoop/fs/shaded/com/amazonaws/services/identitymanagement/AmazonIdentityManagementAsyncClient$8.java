package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccessKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateAccessKeyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$8
  implements Callable<CreateAccessKeyResult>
{
  AmazonIdentityManagementAsyncClient$8(AmazonIdentityManagementAsyncClient this$0, CreateAccessKeyRequest paramCreateAccessKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateAccessKeyResult call()
    throws Exception
  {
    CreateAccessKeyResult result = null;
    try
    {
      result = this$0.executeCreateAccessKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */