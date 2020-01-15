package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLinkedRoleDeletionStatusRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.GetServiceLinkedRoleDeletionStatusResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$75
  implements Callable<GetServiceLinkedRoleDeletionStatusResult>
{
  AmazonIdentityManagementAsyncClient$75(AmazonIdentityManagementAsyncClient this$0, GetServiceLinkedRoleDeletionStatusRequest paramGetServiceLinkedRoleDeletionStatusRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetServiceLinkedRoleDeletionStatusResult call()
    throws Exception
  {
    GetServiceLinkedRoleDeletionStatusResult result = null;
    try
    {
      result = this$0.executeGetServiceLinkedRoleDeletionStatus(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.75
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */