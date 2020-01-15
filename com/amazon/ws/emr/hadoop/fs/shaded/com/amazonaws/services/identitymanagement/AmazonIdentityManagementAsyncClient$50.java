package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateCredentialReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateCredentialReportResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$50
  implements Callable<GenerateCredentialReportResult>
{
  AmazonIdentityManagementAsyncClient$50(AmazonIdentityManagementAsyncClient this$0, GenerateCredentialReportRequest paramGenerateCredentialReportRequest, AsyncHandler paramAsyncHandler) {}
  
  public GenerateCredentialReportResult call()
    throws Exception
  {
    GenerateCredentialReportResult result = null;
    try
    {
      result = this$0.executeGenerateCredentialReport(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.50
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */