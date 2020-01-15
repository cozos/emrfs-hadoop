package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveClientIDFromOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveClientIDFromOpenIDConnectProviderResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$111
  implements Callable<RemoveClientIDFromOpenIDConnectProviderResult>
{
  AmazonIdentityManagementAsyncClient$111(AmazonIdentityManagementAsyncClient this$0, RemoveClientIDFromOpenIDConnectProviderRequest paramRemoveClientIDFromOpenIDConnectProviderRequest, AsyncHandler paramAsyncHandler) {}
  
  public RemoveClientIDFromOpenIDConnectProviderResult call()
    throws Exception
  {
    RemoveClientIDFromOpenIDConnectProviderResult result = null;
    try
    {
      result = this$0.executeRemoveClientIDFromOpenIDConnectProvider(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.111
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */