package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateKeyDescriptionRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.UpdateKeyDescriptionResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$41
  implements Callable<UpdateKeyDescriptionResult>
{
  AWSKMSAsyncClient$41(AWSKMSAsyncClient this$0, UpdateKeyDescriptionRequest paramUpdateKeyDescriptionRequest, AsyncHandler paramAsyncHandler) {}
  
  public UpdateKeyDescriptionResult call()
    throws Exception
  {
    UpdateKeyDescriptionResult result = null;
    try
    {
      result = this$0.executeUpdateKeyDescription(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.41
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */