package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.AddRoleToInstanceProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$2
  implements Callable<AddRoleToInstanceProfileResult>
{
  AmazonIdentityManagementAsyncClient$2(AmazonIdentityManagementAsyncClient this$0, AddRoleToInstanceProfileRequest paramAddRoleToInstanceProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public AddRoleToInstanceProfileResult call()
    throws Exception
  {
    AddRoleToInstanceProfileResult result = null;
    try
    {
      result = this$0.executeAddRoleToInstanceProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */