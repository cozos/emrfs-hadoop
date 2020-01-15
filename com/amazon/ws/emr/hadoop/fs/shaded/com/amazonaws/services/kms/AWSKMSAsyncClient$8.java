package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DeleteAliasResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$8
  implements Callable<DeleteAliasResult>
{
  AWSKMSAsyncClient$8(AWSKMSAsyncClient this$0, DeleteAliasRequest paramDeleteAliasRequest, AsyncHandler paramAsyncHandler) {}
  
  public DeleteAliasResult call()
    throws Exception
  {
    DeleteAliasResult result = null;
    try
    {
      result = this$0.executeDeleteAlias(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.8
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */