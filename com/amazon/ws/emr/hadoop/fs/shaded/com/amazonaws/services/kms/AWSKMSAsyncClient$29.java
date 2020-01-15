package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeysRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListKeysResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$29
  implements Callable<ListKeysResult>
{
  AWSKMSAsyncClient$29(AWSKMSAsyncClient this$0, ListKeysRequest paramListKeysRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListKeysResult call()
    throws Exception
  {
    ListKeysResult result = null;
    try
    {
      result = this$0.executeListKeys(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.29
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */