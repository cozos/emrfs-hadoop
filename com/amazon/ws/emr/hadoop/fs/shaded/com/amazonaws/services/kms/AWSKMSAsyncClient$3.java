package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.CreateAliasResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$3
  implements Callable<CreateAliasResult>
{
  AWSKMSAsyncClient$3(AWSKMSAsyncClient this$0, CreateAliasRequest paramCreateAliasRequest, AsyncHandler paramAsyncHandler) {}
  
  public CreateAliasResult call()
    throws Exception
  {
    CreateAliasResult result = null;
    try
    {
      result = this$0.executeCreateAlias(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.3
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */