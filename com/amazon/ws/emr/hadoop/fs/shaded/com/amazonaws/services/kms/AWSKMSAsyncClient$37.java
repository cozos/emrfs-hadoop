package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.TagResourceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.TagResourceResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$37
  implements Callable<TagResourceResult>
{
  AWSKMSAsyncClient$37(AWSKMSAsyncClient this$0, TagResourceRequest paramTagResourceRequest, AsyncHandler paramAsyncHandler) {}
  
  public TagResourceResult call()
    throws Exception
  {
    TagResourceResult result = null;
    try
    {
      result = this$0.executeTagResource(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.37
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */