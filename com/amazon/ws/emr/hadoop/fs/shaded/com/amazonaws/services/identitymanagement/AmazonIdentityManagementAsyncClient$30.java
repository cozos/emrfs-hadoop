package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteOpenIDConnectProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteOpenIDConnectProviderResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$30
  implements Callable<DeleteOpenIDConnectProviderResult>
{
  AmazonIdentityManagementAsyncClient$30(AmazonIdentityManagementAsyncClient this$0, DeleteOpenIDConnectProviderRequest paramDeleteOpenIDConnectProviderRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteOpenIDConnectProviderResult call()
    throws Exception
  {
    DeleteOpenIDConnectProviderResult result = null;
    try
    {
      result = this$0.executeDeleteOpenIDConnectProvider(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */