package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetDefaultPolicyVersionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SetDefaultPolicyVersionResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$116
  implements Callable<SetDefaultPolicyVersionResult>
{
  AmazonIdentityManagementAsyncClient$116(AmazonIdentityManagementAsyncClient this$0, SetDefaultPolicyVersionRequest paramSetDefaultPolicyVersionRequest, AsyncHandler paramAsyncHandler) {}
  
  public SetDefaultPolicyVersionResult call()
    throws Exception
  {
    SetDefaultPolicyVersionResult result = null;
    try
    {
      result = this$0.executeSetDefaultPolicyVersion(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.116
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */