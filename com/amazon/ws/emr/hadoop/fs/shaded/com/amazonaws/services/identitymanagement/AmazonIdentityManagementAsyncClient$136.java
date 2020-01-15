package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSigningCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UpdateSigningCertificateResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$136
  implements Callable<UpdateSigningCertificateResult>
{
  AmazonIdentityManagementAsyncClient$136(AmazonIdentityManagementAsyncClient this$0, UpdateSigningCertificateRequest paramUpdateSigningCertificateRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateSigningCertificateResult call()
    throws Exception
  {
    UpdateSigningCertificateResult result = null;
    try
    {
      result = this$0.executeUpdateSigningCertificate(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.136
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */