package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetGroupResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$60
  implements Callable<GetGroupResult>
{
  AmazonIdentityManagementAsyncClient$60(AmazonIdentityManagementAsyncClient this$0, GetGroupRequest paramGetGroupRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetGroupResult call()
    throws Exception
  {
    GetGroupResult result = null;
    try
    {
      result = this$0.executeGetGroup(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.60
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */