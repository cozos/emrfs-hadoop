package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServerCertificatesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListServerCertificatesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$99
  implements Callable<ListServerCertificatesResult>
{
  AmazonIdentityManagementAsyncClient$99(AmazonIdentityManagementAsyncClient this$0, ListServerCertificatesRequest paramListServerCertificatesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListServerCertificatesResult call()
    throws Exception
  {
    ListServerCertificatesResult result = null;
    try
    {
      result = this$0.executeListServerCertificates(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.99
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */