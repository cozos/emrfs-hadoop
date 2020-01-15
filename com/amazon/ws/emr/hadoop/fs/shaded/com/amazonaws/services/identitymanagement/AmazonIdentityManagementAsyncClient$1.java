package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddClientIDToOpenIDConnectProviderResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$1
  implements Callable<AddClientIDToOpenIDConnectProviderResult>
{
  AmazonIdentityManagementAsyncClient$1(AmazonIdentityManagementAsyncClient this$0, AddClientIDToOpenIDConnectProviderRequest paramAddClientIDToOpenIDConnectProviderRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddClientIDToOpenIDConnectProviderResult call()
    throws Exception
  {
    AddClientIDToOpenIDConnectProviderResult result = null;
    try
    {
      result = this$0.executeAddClientIDToOpenIDConnectProvider(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */