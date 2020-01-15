package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetSessionTokenResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$8
  implements Callable<GetSessionTokenResult>
{
  AWSSecurityTokenServiceAsyncClient$8(AWSSecurityTokenServiceAsyncClient this$0, GetSessionTokenRequest paramGetSessionTokenRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetSessionTokenResult call()
    throws Exception
  {
    GetSessionTokenResult result = null;
    try
    {
      result = this$0.executeGetSessionToken(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */