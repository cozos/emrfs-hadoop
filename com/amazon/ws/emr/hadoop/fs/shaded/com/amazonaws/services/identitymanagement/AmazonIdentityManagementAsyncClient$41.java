package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteSigningCertificateResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$41
  implements Callable<DeleteSigningCertificateResult>
{
  AmazonIdentityManagementAsyncClient$41(AmazonIdentityManagementAsyncClient this$0, DeleteSigningCertificateRequest paramDeleteSigningCertificateRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteSigningCertificateResult call()
    throws Exception
  {
    DeleteSigningCertificateResult result = null;
    try
    {
      result = this$0.executeDeleteSigningCertificate(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.41
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */