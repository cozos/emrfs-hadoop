package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListRetirableGrantsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListRetirableGrantsResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$31
  implements Callable<ListRetirableGrantsResult>
{
  AWSKMSAsyncClient$31(AWSKMSAsyncClient this$0, ListRetirableGrantsRequest paramListRetirableGrantsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListRetirableGrantsResult call()
    throws Exception
  {
    ListRetirableGrantsResult result = null;
    try
    {
      result = this$0.executeListRetirableGrants(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.31
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */