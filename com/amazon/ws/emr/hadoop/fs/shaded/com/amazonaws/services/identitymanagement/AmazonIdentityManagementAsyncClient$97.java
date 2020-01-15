package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSAMLProvidersRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSAMLProvidersResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$97
  implements Callable<ListSAMLProvidersResult>
{
  AmazonIdentityManagementAsyncClient$97(AmazonIdentityManagementAsyncClient this$0, ListSAMLProvidersRequest paramListSAMLProvidersRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListSAMLProvidersResult call()
    throws Exception
  {
    ListSAMLProvidersResult result = null;
    try
    {
      result = this$0.executeListSAMLProviders(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.97
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */