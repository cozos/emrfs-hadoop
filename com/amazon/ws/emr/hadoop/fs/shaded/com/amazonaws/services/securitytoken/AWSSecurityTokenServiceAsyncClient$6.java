package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetCallerIdentityResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$6
  implements Callable<GetCallerIdentityResult>
{
  AWSSecurityTokenServiceAsyncClient$6(AWSSecurityTokenServiceAsyncClient this$0, GetCallerIdentityRequest paramGetCallerIdentityRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetCallerIdentityResult call()
    throws Exception
  {
    GetCallerIdentityResult result = null;
    try
    {
      result = this$0.executeGetCallerIdentity(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.6
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */