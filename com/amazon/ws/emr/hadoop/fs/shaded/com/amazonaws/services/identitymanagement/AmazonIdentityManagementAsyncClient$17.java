package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateSAMLProviderResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$17
  implements Callable<CreateSAMLProviderResult>
{
  AmazonIdentityManagementAsyncClient$17(AmazonIdentityManagementAsyncClient this$0, CreateSAMLProviderRequest paramCreateSAMLProviderRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateSAMLProviderResult call()
    throws Exception
  {
    CreateSAMLProviderResult result = null;
    try
    {
      result = this$0.executeCreateSAMLProvider(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.17
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */