package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetCredentialReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetCredentialReportResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$59
  implements Callable<GetCredentialReportResult>
{
  AmazonIdentityManagementAsyncClient$59(AmazonIdentityManagementAsyncClient this$0, GetCredentialReportRequest paramGetCredentialReportRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetCredentialReportResult call()
    throws Exception
  {
    GetCredentialReportResult result = null;
    try
    {
      result = this$0.executeGetCredentialReport(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.59
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */