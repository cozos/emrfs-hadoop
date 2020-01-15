package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.CreateVirtualMFADeviceResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$21
  implements Callable<CreateVirtualMFADeviceResult>
{
  AmazonIdentityManagementAsyncClient$21(AmazonIdentityManagementAsyncClient this$0, CreateVirtualMFADeviceRequest paramCreateVirtualMFADeviceRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateVirtualMFADeviceResult call()
    throws Exception
  {
    CreateVirtualMFADeviceResult result = null;
    try
    {
      result = this$0.executeCreateVirtualMFADevice(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.21
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */