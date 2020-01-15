package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ScanResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$26
  implements Callable<ScanResult>
{
  AmazonDynamoDBAsyncClient$26(AmazonDynamoDBAsyncClient this$0, ScanRequest paramScanRequest, AsyncHandler paramAsyncHandler) {}
  
  public ScanResult call()
    throws Exception
  {
    ScanResult result = null;
    try
    {
      result = this$0.executeScan(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.26
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */