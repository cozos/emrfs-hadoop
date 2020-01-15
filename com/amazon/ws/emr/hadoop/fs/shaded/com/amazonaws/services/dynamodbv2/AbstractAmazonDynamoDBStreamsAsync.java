package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.handlers.AsyncHandler;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsResult;
import java.util.concurrent.Future;

public class AbstractAmazonDynamoDBStreamsAsync
  extends AbstractAmazonDynamoDBStreams
  implements AmazonDynamoDBStreamsAsync
{
  public Future<DescribeStreamResult> describeStreamAsync(DescribeStreamRequest request)
  {
    return describeStreamAsync(request, null);
  }
  
  public Future<DescribeStreamResult> describeStreamAsync(DescribeStreamRequest request, AsyncHandler<DescribeStreamRequest, DescribeStreamResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetRecordsResult> getRecordsAsync(GetRecordsRequest request)
  {
    return getRecordsAsync(request, null);
  }
  
  public Future<GetRecordsResult> getRecordsAsync(GetRecordsRequest request, AsyncHandler<GetRecordsRequest, GetRecordsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<GetShardIteratorResult> getShardIteratorAsync(GetShardIteratorRequest request)
  {
    return getShardIteratorAsync(request, null);
  }
  
  public Future<GetShardIteratorResult> getShardIteratorAsync(GetShardIteratorRequest request, AsyncHandler<GetShardIteratorRequest, GetShardIteratorResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
  
  public Future<ListStreamsResult> listStreamsAsync(ListStreamsRequest request)
  {
    return listStreamsAsync(request, null);
  }
  
  public Future<ListStreamsResult> listStreamsAsync(ListStreamsRequest request, AsyncHandler<ListStreamsRequest, ListStreamsResult> asyncHandler)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AbstractAmazonDynamoDBStreamsAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */