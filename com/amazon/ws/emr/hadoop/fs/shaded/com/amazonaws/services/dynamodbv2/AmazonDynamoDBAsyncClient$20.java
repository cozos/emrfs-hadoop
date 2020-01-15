package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListTablesResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$20
  implements Callable<ListTablesResult>
{
  AmazonDynamoDBAsyncClient$20(AmazonDynamoDBAsyncClient this$0, ListTablesRequest paramListTablesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListTablesResult call()
    throws Exception
  {
    ListTablesResult result = null;
    try
    {
      result = this$0.executeListTables(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.20
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */