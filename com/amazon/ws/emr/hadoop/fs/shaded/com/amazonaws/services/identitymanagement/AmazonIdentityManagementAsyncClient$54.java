package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountAuthorizationDetailsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$54
  implements Callable<GetAccountAuthorizationDetailsResult>
{
  AmazonIdentityManagementAsyncClient$54(AmazonIdentityManagementAsyncClient this$0, GetAccountAuthorizationDetailsRequest paramGetAccountAuthorizationDetailsRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetAccountAuthorizationDetailsResult call()
    throws Exception
  {
    GetAccountAuthorizationDetailsResult result = null;
    try
    {
      result = this$0.executeGetAccountAuthorizationDetails(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.54
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */