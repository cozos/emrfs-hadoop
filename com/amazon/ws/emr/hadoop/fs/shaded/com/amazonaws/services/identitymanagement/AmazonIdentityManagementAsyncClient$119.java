package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.model.SimulatePrincipalPolicyResult;
import java.util.concurrent.Callable;

class AmazonIdentityManagementAsyncClient$119
  implements Callable<SimulatePrincipalPolicyResult>
{
  AmazonIdentityManagementAsyncClient$119(AmazonIdentityManagementAsyncClient this$0, SimulatePrincipalPolicyRequest paramSimulatePrincipalPolicyRequest, AsyncHandler paramAsyncHandler) {}
  
  public SimulatePrincipalPolicyResult call()
    throws Exception
  {
    SimulatePrincipalPolicyResult result = null;
    try
    {
      result = this$0.executeSimulatePrincipalPolicy(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.identitymanagement.AmazonIdentityManagementAsyncClient.119
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */