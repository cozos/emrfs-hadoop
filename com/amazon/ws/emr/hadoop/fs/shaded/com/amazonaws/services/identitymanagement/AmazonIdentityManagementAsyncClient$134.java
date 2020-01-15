package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateServerCertificateResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$134
  implements Callable<UpdateServerCertificateResult>
{
  AmazonIdentityManagementAsyncClient$134(AmazonIdentityManagementAsyncClient this$0, UpdateServerCertificateRequest paramUpdateServerCertificateRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateServerCertificateResult call()
    throws Exception
  {
    UpdateServerCertificateResult result = null;
    try
    {
      result = this$0.executeUpdateServerCertificate(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.134
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */