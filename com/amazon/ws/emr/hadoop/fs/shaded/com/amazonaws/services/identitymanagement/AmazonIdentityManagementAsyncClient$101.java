package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSigningCertificatesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListSigningCertificatesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$101
  implements Callable<ListSigningCertificatesResult>
{
  AmazonIdentityManagementAsyncClient$101(AmazonIdentityManagementAsyncClient this$0, ListSigningCertificatesRequest paramListSigningCertificatesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListSigningCertificatesResult call()
    throws Exception
  {
    ListSigningCertificatesResult result = null;
    try
    {
      result = this$0.executeListSigningCertificates(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.101
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */