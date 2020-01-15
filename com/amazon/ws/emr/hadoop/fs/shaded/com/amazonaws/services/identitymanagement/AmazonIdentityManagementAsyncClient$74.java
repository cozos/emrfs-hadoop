package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsWithEntitiesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLastAccessedDetailsWithEntitiesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$74
  implements Callable<GetServiceLastAccessedDetailsWithEntitiesResult>
{
  AmazonIdentityManagementAsyncClient$74(AmazonIdentityManagementAsyncClient this$0, GetServiceLastAccessedDetailsWithEntitiesRequest paramGetServiceLastAccessedDetailsWithEntitiesRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetServiceLastAccessedDetailsWithEntitiesResult call()
    throws Exception
  {
    GetServiceLastAccessedDetailsWithEntitiesResult result = null;
    try
    {
      result = this$0.executeGetServiceLastAccessedDetailsWithEntities(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.74
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */