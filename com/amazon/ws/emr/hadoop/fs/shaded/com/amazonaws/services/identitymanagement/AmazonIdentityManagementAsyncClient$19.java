package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceSpecificCredentialRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateServiceSpecificCredentialResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$19
  implements Callable<CreateServiceSpecificCredentialResult>
{
  AmazonIdentityManagementAsyncClient$19(AmazonIdentityManagementAsyncClient this$0, CreateServiceSpecificCredentialRequest paramCreateServiceSpecificCredentialRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateServiceSpecificCredentialResult call()
    throws Exception
  {
    CreateServiceSpecificCredentialResult result = null;
    try
    {
      result = this$0.executeCreateServiceSpecificCredential(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */