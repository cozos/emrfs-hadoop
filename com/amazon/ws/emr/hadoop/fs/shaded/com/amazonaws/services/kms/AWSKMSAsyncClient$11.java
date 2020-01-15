package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeCustomKeyStoresRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeCustomKeyStoresResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$11
  implements Callable<DescribeCustomKeyStoresResult>
{
  AWSKMSAsyncClient$11(AWSKMSAsyncClient this$0, DescribeCustomKeyStoresRequest paramDescribeCustomKeyStoresRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeCustomKeyStoresResult call()
    throws Exception
  {
    DescribeCustomKeyStoresResult result = null;
    try
    {
      result = this$0.executeDescribeCustomKeyStores(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.11
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */