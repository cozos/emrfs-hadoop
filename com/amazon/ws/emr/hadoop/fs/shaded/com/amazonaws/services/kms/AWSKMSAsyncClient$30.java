package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListResourceTagsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListResourceTagsResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$30
  implements Callable<ListResourceTagsResult>
{
  AWSKMSAsyncClient$30(AWSKMSAsyncClient this$0, ListResourceTagsRequest paramListResourceTagsRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListResourceTagsResult call()
    throws Exception
  {
    ListResourceTagsResult result = null;
    try
    {
      result = this$0.executeListResourceTags(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.30
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */