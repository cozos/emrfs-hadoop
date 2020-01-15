package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateServiceLastAccessedDetailsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GenerateServiceLastAccessedDetailsResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$52
  implements Callable<GenerateServiceLastAccessedDetailsResult>
{
  AmazonIdentityManagementAsyncClient$52(AmazonIdentityManagementAsyncClient this$0, GenerateServiceLastAccessedDetailsRequest paramGenerateServiceLastAccessedDetailsRequest, AsyncHandler paramAsyncHandler) {}
  
  public GenerateServiceLastAccessedDetailsResult call()
    throws Exception
  {
    GenerateServiceLastAccessedDetailsResult result = null;
    try
    {
      result = this$0.executeGenerateServiceLastAccessedDetails(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.52
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */