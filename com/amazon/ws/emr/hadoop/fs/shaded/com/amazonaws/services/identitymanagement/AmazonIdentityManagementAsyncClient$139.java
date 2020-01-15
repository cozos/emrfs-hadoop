package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.UploadServerCertificateResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$139
  implements Callable<UploadServerCertificateResult>
{
  AmazonIdentityManagementAsyncClient$139(AmazonIdentityManagementAsyncClient this$0, UploadServerCertificateRequest paramUploadServerCertificateRequest, AsyncHandler paramAsyncHandler) {}
  
  public UploadServerCertificateResult call()
    throws Exception
  {
    UploadServerCertificateResult result = null;
    try
    {
      result = this$0.executeUploadServerCertificate(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.139
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */