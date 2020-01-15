package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.DecodeAuthorizationMessageResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$4
  implements Callable<DecodeAuthorizationMessageResult>
{
  AWSSecurityTokenServiceAsyncClient$4(AWSSecurityTokenServiceAsyncClient this$0, DecodeAuthorizationMessageRequest paramDecodeAuthorizationMessageRequest, AsyncHandler paramAsyncHandler) {}
  
  public DecodeAuthorizationMessageResult call()
    throws Exception
  {
    DecodeAuthorizationMessageResult result = null;
    try
    {
      result = this$0.executeDecodeAuthorizationMessage(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.4
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */