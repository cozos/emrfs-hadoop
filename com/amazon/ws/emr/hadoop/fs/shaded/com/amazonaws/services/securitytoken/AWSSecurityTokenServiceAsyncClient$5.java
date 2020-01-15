package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.GetAccessKeyInfoResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$5
  implements Callable<GetAccessKeyInfoResult>
{
  AWSSecurityTokenServiceAsyncClient$5(AWSSecurityTokenServiceAsyncClient this$0, GetAccessKeyInfoRequest paramGetAccessKeyInfoRequest, AsyncHandler paramAsyncHandler) {}
  
  public GetAccessKeyInfoResult call()
    throws Exception
  {
    GetAccessKeyInfoResult result = null;
    try
    {
      result = this$0.executeGetAccessKeyInfo(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */