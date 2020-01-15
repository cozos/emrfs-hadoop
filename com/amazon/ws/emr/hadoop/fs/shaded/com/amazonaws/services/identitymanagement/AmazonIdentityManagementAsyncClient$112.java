package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveRoleFromInstanceProfileRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.RemoveRoleFromInstanceProfileResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$112
  implements Callable<RemoveRoleFromInstanceProfileResult>
{
  AmazonIdentityManagementAsyncClient$112(AmazonIdentityManagementAsyncClient this$0, RemoveRoleFromInstanceProfileRequest paramRemoveRoleFromInstanceProfileRequest, AsyncHandler paramAsyncHandler) {}
  
  public RemoveRoleFromInstanceProfileResult call()
    throws Exception
  {
    RemoveRoleFromInstanceProfileResult result = null;
    try
    {
      result = this$0.executeRemoveRoleFromInstanceProfile(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.112
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */