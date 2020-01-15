package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListGrantsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListGrantsResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$27
  implements Callable<ListGrantsResult>
{
  AWSKMSAsyncClient$27(AWSKMSAsyncClient this$0, ListGrantsRequest paramListGrantsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListGrantsResult call()
    throws Exception
  {
    ListGrantsResult result = null;
    try
    {
      result = this$0.executeListGrants(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.27
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */