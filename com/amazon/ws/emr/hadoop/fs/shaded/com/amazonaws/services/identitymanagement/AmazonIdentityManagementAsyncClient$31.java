package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.DeletePolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$31
  implements Callable<DeletePolicyResult>
{
  AmazonIdentityManagementAsyncClient$31(AmazonIdentityManagementAsyncClient this$0, DeletePolicyRequest paramDeletePolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeletePolicyResult call()
    throws Exception
  {
    DeletePolicyResult result = null;
    try
    {
      result = this$0.executeDeletePolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.31
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */