package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeKeyRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.model.DescribeKeyResult;
import java.util.concurrent.Callable;

class AWSKMSAsyncClient$12
  implements Callable<DescribeKeyResult>
{
  AWSKMSAsyncClient$12(AWSKMSAsyncClient this$0, DescribeKeyRequest paramDescribeKeyRequest, AsyncHandler paramAsyncHandler) {}
  
  public DescribeKeyResult call()
    throws Exception
  {
    DescribeKeyResult result = null;
    try
    {
      result = this$0.executeDescribeKey(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.kms.AWSKMSAsyncClient.12
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */