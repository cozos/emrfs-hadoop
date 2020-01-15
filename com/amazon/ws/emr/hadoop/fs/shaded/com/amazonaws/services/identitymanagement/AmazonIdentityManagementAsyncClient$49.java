package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EnableMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.EnableMFADeviceResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$49
  implements Callable<EnableMFADeviceResult>
{
  AmazonIdentityManagementAsyncClient$49(AmazonIdentityManagementAsyncClient this$0, EnableMFADeviceRequest paramEnableMFADeviceRequest, AsyncHandler paramAsyncHandler) {}
  
  public EnableMFADeviceResult call()
    throws Exception
  {
    EnableMFADeviceResult result = null;
    try
    {
      result = this$0.executeEnableMFADevice(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.49
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */