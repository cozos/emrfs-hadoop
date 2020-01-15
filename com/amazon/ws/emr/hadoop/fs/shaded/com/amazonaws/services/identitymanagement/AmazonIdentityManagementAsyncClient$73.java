package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$73
  implements Callable<GetServiceLastAccessedDetailsResult>
{
  AmazonIdentityManagementAsyncClient$73(AmazonIdentityManagementAsyncClient this$0, GetServiceLastAccessedDetailsRequest paramGetServiceLastAccessedDetailsRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetServiceLastAccessedDetailsResult call()
    throws Exception
  {
    GetServiceLastAccessedDetailsResult result = null;
    try
    {
      result = this$0.executeGetServiceLastAccessedDetails(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.73
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */