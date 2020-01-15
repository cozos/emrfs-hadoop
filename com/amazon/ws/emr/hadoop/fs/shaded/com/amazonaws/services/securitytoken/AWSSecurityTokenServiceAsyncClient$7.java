package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetFederationTokenResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$7
  implements Callable<GetFederationTokenResult>
{
  AWSSecurityTokenServiceAsyncClient$7(AWSSecurityTokenServiceAsyncClient this$0, GetFederationTokenRequest paramGetFederationTokenRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetFederationTokenResult call()
    throws Exception
  {
    GetFederationTokenResult result = null;
    try
    {
      result = this$0.executeGetFederationToken(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.7
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */