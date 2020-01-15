package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetSAMLProviderResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$70
  implements Callable<GetSAMLProviderResult>
{
  AmazonIdentityManagementAsyncClient$70(AmazonIdentityManagementAsyncClient this$0, GetSAMLProviderRequest paramGetSAMLProviderRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetSAMLProviderResult call()
    throws Exception
  {
    GetSAMLProviderResult result = null;
    try
    {
      result = this$0.executeGetSAMLProvider(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.70
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */