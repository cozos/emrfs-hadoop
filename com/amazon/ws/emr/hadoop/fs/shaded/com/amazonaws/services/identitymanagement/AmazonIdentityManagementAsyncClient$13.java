package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateOpenIDConnectProviderResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$13
  implements Callable<CreateOpenIDConnectProviderResult>
{
  AmazonIdentityManagementAsyncClient$13(AmazonIdentityManagementAsyncClient this$0, CreateOpenIDConnectProviderRequest paramCreateOpenIDConnectProviderRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateOpenIDConnectProviderResult call()
    throws Exception
  {
    CreateOpenIDConnectProviderResult result = null;
    try
    {
      result = this$0.executeCreateOpenIDConnectProvider(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.13
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */