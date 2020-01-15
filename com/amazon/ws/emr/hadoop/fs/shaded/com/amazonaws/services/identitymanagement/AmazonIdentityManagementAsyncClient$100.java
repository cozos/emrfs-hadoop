package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServiceSpecificCredentialsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$100
  implements Callable<ListServiceSpecificCredentialsResult>
{
  AmazonIdentityManagementAsyncClient$100(AmazonIdentityManagementAsyncClient this$0, ListServiceSpecificCredentialsRequest paramListServiceSpecificCredentialsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListServiceSpecificCredentialsResult call()
    throws Exception
  {
    ListServiceSpecificCredentialsResult result = null;
    try
    {
      result = this$0.executeListServiceSpecificCredentials(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.100
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */