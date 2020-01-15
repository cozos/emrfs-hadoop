package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateOrganizationsAccessReportResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$51
  implements Callable<GenerateOrganizationsAccessReportResult>
{
  AmazonIdentityManagementAsyncClient$51(AmazonIdentityManagementAsyncClient this$0, GenerateOrganizationsAccessReportRequest paramGenerateOrganizationsAccessReportRequest, AsyncHandler paramAsyncHandler) {}
  
  public GenerateOrganizationsAccessReportResult call()
    throws Exception
  {
    GenerateOrganizationsAccessReportResult result = null;
    try
    {
      result = this$0.executeGenerateOrganizationsAccessReport(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.51
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */