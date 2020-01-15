package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithWebIdentityResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$3
  implements Callable<AssumeRoleWithWebIdentityResult>
{
  AWSSecurityTokenServiceAsyncClient$3(AWSSecurityTokenServiceAsyncClient this$0, AssumeRoleWithWebIdentityRequest paramAssumeRoleWithWebIdentityRequest, AsyncHandler paramAsyncHandler) {}
  
  public AssumeRoleWithWebIdentityResult call()
    throws Exception
  {
    AssumeRoleWithWebIdentityResult result = null;
    try
    {
      result = this$0.executeAssumeRoleWithWebIdentity(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */