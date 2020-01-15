package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeleteServerCertificateResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$38
  implements Callable<DeleteServerCertificateResult>
{
  AmazonIdentityManagementAsyncClient$38(AmazonIdentityManagementAsyncClient this$0, DeleteServerCertificateRequest paramDeleteServerCertificateRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteServerCertificateResult call()
    throws Exception
  {
    DeleteServerCertificateResult result = null;
    try
    {
      result = this$0.executeDeleteServerCertificate(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.38
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */