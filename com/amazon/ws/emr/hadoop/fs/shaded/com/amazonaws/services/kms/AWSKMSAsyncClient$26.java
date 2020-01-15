package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListAliasesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.ListAliasesResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$26
  implements Callable<ListAliasesResult>
{
  AWSKMSAsyncClient$26(AWSKMSAsyncClient this$0, ListAliasesRequest paramListAliasesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListAliasesResult call()
    throws Exception
  {
    ListAliasesResult result = null;
    try
    {
      result = this$0.executeListAliases(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */