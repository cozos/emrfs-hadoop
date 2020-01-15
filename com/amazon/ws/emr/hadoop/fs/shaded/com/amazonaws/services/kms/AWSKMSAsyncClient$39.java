package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateAliasRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateAliasResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$39
  implements Callable<UpdateAliasResult>
{
  AWSKMSAsyncClient$39(AWSKMSAsyncClient this$0, UpdateAliasRequest paramUpdateAliasRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateAliasResult call()
    throws Exception
  {
    UpdateAliasResult result = null;
    try
    {
      result = this$0.executeUpdateAlias(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.39
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */