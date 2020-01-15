package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.model.AssumeRoleWithSAMLResult;
import java.util.concurrent.Callable;

class AWSSecurityTokenServiceAsyncClient$2
  implements Callable<AssumeRoleWithSAMLResult>
{
  AWSSecurityTokenServiceAsyncClient$2(AWSSecurityTokenServiceAsyncClient this$0, AssumeRoleWithSAMLRequest paramAssumeRoleWithSAMLRequest, AsyncHandler paramAsyncHandler) {}
  
  public AssumeRoleWithSAMLResult call()
    throws Exception
  {
    AssumeRoleWithSAMLResult result = null;
    try
    {
      result = this$0.executeAssumeRoleWithSAML(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.securitytoken.AWSSecurityTokenServiceAsyncClient.2
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */