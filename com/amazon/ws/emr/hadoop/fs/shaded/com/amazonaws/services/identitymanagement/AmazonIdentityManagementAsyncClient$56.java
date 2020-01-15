package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountSummaryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccountSummaryResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$56
  implements Callable<GetAccountSummaryResult>
{
  AmazonIdentityManagementAsyncClient$56(AmazonIdentityManagementAsyncClient this$0, GetAccountSummaryRequest paramGetAccountSummaryRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetAccountSummaryResult call()
    throws Exception
  {
    GetAccountSummaryResult result = null;
    try
    {
      result = this$0.executeGetAccountSummary(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.56
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */