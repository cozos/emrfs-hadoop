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

public class AbstractAmazonDynamoDBStreams
  implements AmazonDynamoDBStreams
{
  public void setEndpoint(String endpoint)
  {
    throw new UnsupportedOperationException();
  }
  
  public void setRegion(Region region)
  {
    throw new UnsupportedOperationException();
  }
  
  public DescribeStreamResult describeStream(DescribeStreamRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetRecordsResult getRecords(GetRecordsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public GetShardIteratorResult getShardIterator(GetShardIteratorRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public ListStreamsResult listStreams(ListStreamsRequest request)
  {
    throw new UnsupportedOperationException();
  }
  
  public void shutdown()
  {
    throw new UnsupportedOperationException();
  }
  
  public ResponseMetadata getCachedResponseMetadata(AmazonWebServiceRequest request)
  {
    throw new UnsupportedOperationException();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AbstractAmazonDynamoDBStreams
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */