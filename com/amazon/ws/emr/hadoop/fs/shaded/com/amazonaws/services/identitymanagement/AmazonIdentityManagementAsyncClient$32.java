package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyVersionResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$32
  implements Callable<DeletePolicyVersionResult>
{
  AmazonIdentityManagementAsyncClient$32(AmazonIdentityManagementAsyncClient this$0, DeletePolicyVersionRequest paramDeletePolicyVersionRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeletePolicyVersionResult call()
    throws Exception
  {
    DeletePolicyVersionResult result = null;
    try
    {
      result = this$0.executeDeletePolicyVersion(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.32
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */