package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResyncMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ResyncMFADeviceResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$115
  implements Callable<ResyncMFADeviceResult>
{
  AmazonIdentityManagementAsyncClient$115(AmazonIdentityManagementAsyncClient this$0, ResyncMFADeviceRequest paramResyncMFADeviceRequest, AsyncHandler paramAsyncHandler) {}
  
  public ResyncMFADeviceResult call()
    throws Exception
  {
    ResyncMFADeviceResult result = null;
    try
    {
      result = this$0.executeResyncMFADevice(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.115
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */