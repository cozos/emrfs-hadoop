package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServerCertificateResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$72
  implements Callable<GetServerCertificateResult>
{
  AmazonIdentityManagementAsyncClient$72(AmazonIdentityManagementAsyncClient this$0, GetServerCertificateRequest paramGetServerCertificateRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetServerCertificateResult call()
    throws Exception
  {
    GetServerCertificateResult result = null;
    try
    {
      result = this$0.executeGetServerCertificate(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.72
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */