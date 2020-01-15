package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListMFADevicesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListMFADevicesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$89
  implements Callable<ListMFADevicesResult>
{
  AmazonIdentityManagementAsyncClient$89(AmazonIdentityManagementAsyncClient this$0, ListMFADevicesRequest paramListMFADevicesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListMFADevicesResult call()
    throws Exception
  {
    ListMFADevicesResult result = null;
    try
    {
      result = this$0.executeListMFADevices(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.89
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */