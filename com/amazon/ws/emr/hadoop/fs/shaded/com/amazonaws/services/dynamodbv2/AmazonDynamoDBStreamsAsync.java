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

public abstract interface AmazonDynamoDBStreamsAsync
  extends AmazonDynamoDBStreams
{
  public abstract Future<DescribeStreamResult> describeStreamAsync(DescribeStreamRequest paramDescribeStreamRequest);
  
  public abstract Future<DescribeStreamResult> describeStreamAsync(DescribeStreamRequest paramDescribeStreamRequest, AsyncHandler<DescribeStreamRequest, DescribeStreamResult> paramAsyncHandler);
  
  public abstract Future<GetRecordsResult> getRecordsAsync(GetRecordsRequest paramGetRecordsRequest);
  
  public abstract Future<GetRecordsResult> getRecordsAsync(GetRecordsRequest paramGetRecordsRequest, AsyncHandler<GetRecordsRequest, GetRecordsResult> paramAsyncHandler);
  
  public abstract Future<GetShardIteratorResult> getShardIteratorAsync(GetShardIteratorRequest paramGetShardIteratorRequest);
  
  public abstract Future<GetShardIteratorResult> getShardIteratorAsync(GetShardIteratorRequest paramGetShardIteratorRequest, AsyncHandler<GetShardIteratorRequest, GetShardIteratorResult> paramAsyncHandler);
  
  public abstract Future<ListStreamsResult> listStreamsAsync(ListStreamsRequest paramListStreamsRequest);
  
  public abstract Future<ListStreamsResult> listStreamsAsync(ListStreamsRequest paramListStreamsRequest, AsyncHandler<ListStreamsRequest, ListStreamsResult> paramAsyncHandler);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreamsAsync
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */