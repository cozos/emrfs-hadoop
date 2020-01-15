package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetOrganizationsAccessReportResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$65
  implements Callable<GetOrganizationsAccessReportResult>
{
  AmazonIdentityManagementAsyncClient$65(AmazonIdentityManagementAsyncClient this$0, GetOrganizationsAccessReportRequest paramGetOrganizationsAccessReportRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetOrganizationsAccessReportResult call()
    throws Exception
  {
    GetOrganizationsAccessReportResult result = null;
    try
    {
      result = this$0.executeGetOrganizationsAccessReport(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.65
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */