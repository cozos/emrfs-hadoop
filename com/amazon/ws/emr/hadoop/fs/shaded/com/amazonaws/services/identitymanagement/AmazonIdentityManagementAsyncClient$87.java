package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.ListInstanceProfilesResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$87
  implements Callable<ListInstanceProfilesResult>
{
  AmazonIdentityManagementAsyncClient$87(AmazonIdentityManagementAsyncClient this$0, ListInstanceProfilesRequest paramListInstanceProfilesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListInstanceProfilesResult call()
    throws Exception
  {
    ListInstanceProfilesResult result = null;
    try
    {
      result = this$0.executeListInstanceProfiles(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.87
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */