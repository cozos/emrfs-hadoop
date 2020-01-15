package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListGlobalTablesResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$19
  implements Callable<ListGlobalTablesResult>
{
  AmazonDynamoDBAsyncClient$19(AmazonDynamoDBAsyncClient this$0, ListGlobalTablesRequest paramListGlobalTablesRequest, AsyncHandler paramAsyncHandler) {}
  
  public ListGlobalTablesResult call()
    throws Exception
  {
    ListGlobalTablesResult result = null;
    try
    {
      result = this$0.executeListGlobalTables(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.19
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */