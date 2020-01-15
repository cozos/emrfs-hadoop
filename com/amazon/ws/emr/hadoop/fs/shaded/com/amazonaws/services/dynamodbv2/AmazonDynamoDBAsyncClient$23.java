package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.QueryResult;
import java.util.concurrent.Callable;

class AmazonDynamoDBAsyncClient$23
  implements Callable<QueryResult>
{
  AmazonDynamoDBAsyncClient$23(AmazonDynamoDBAsyncClient this$0, QueryRequest paramQueryRequest, AsyncHandler paramAsyncHandler) {}
  
  public QueryResult call()
    throws Exception
  {
    QueryResult result = null;
    try
    {
      result = this$0.executeQuery(val$finalRequest);
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
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBAsyncClient.23
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */