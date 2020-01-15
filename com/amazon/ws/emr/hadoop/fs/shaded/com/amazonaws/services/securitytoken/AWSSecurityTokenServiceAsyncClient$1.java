package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$1
  implements Callable<AssumeRoleResult>
{
  AWSSecurityTokenServiceAsyncClient$1(AWSSecurityTokenServiceAsyncClient this$0, AssumeRoleRequest paramAssumeRoleRequest, AsyncHandler paramAsyncHandler) {}
  
  public AssumeRoleResult call()
    throws Exception
  {
    AssumeRoleResult result = null;
    try
    {
      result = this$0.executeAssumeRole(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.1
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */