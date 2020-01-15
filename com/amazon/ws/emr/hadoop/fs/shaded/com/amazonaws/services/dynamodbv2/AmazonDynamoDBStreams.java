package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ResponseMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeStreamResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetRecordsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.GetShardIteratorResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.ListStreamsResult;

public abstract interface AmazonDynamoDBStreams
{
  public static final String ENDPOINT_PREFIX = "streams.dynamodb";
  
  @Deprecated
  public abstract void setEndpoint(String paramString);
  
  @Deprecated
  public abstract void setRegion(Region paramRegion);
  
  public abstract DescribeStreamResult describeStream(DescribeStreamRequest paramDescribeStreamRequest);
  
  public abstract GetRecordsResult getRecords(GetRecordsRequest paramGetRecordsRequest);
  
  public abstract GetShardIteratorResult getShardIterator(GetShardIteratorRequest paramGetShardIteratorRequest);
  
  public abstract ListStreamsResult listStreams(ListStreamsRequest paramListStreamsRequest);
  
  public abstract void shutdown();
  
  public abstract ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest paramAmazonWebServiceRequest);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDBStreams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */