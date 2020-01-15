package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeactivateMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeactivateMFADeviceResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$22
  implements Callable<DeactivateMFADeviceResult>
{
  AmazonIdentityManagementAsyncClient$22(AmazonIdentityManagementAsyncClient this$0, DeactivateMFADeviceRequest paramDeactivateMFADeviceRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeactivateMFADeviceResult call()
    throws Exception
  {
    DeactivateMFADeviceResult result = null;
    try
    {
      result = this$0.executeDeactivateMFADevice(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.22
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */