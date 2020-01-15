package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSAMLProviderRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSAMLProviderResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$36
  implements Callable<DeleteSAMLProviderResult>
{
  AmazonIdentityManagementAsyncClient$36(AmazonIdentityManagementAsyncClient this$0, DeleteSAMLProviderRequest paramDeleteSAMLProviderRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteSAMLProviderResult call()
    throws Exception
  {
    DeleteSAMLProviderResult result = null;
    try
    {
      result = this$0.executeDeleteSAMLProvider(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.36
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */