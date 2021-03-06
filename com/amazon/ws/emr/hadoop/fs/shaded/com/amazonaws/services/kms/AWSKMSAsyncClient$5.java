package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateGrantRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateGrantResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$5
  implements Callable<CreateGrantResult>
{
  AWSKMSAsyncClient$5(AWSKMSAsyncClient this$0, CreateGrantRequest paramCreateGrantRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateGrantResult call()
    throws Exception
  {
    CreateGrantResult result = null;
    try
    {
      result = this$0.executeCreateGrant(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.5
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */