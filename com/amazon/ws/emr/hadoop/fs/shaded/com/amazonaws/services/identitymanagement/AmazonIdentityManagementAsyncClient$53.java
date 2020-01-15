package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccessKeyLastUsedRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetAccessKeyLastUsedResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$53
  implements Callable<GetAccessKeyLastUsedResult>
{
  AmazonIdentityManagementAsyncClient$53(AmazonIdentityManagementAsyncClient this$0, GetAccessKeyLastUsedRequest paramGetAccessKeyLastUsedRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetAccessKeyLastUsedResult call()
    throws Exception
  {
    GetAccessKeyLastUsedResult result = null;
    try
    {
      result = this$0.executeGetAccessKeyLastUsed(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.53
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */