package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.model.DescribeTableResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class DescribeTableFunction
  implements SdkFunction<DescribeTableRequest, DescribeTableResult>
{
  private final AmazonDynamoDB client;
  
  public DescribeTableFunction(AmazonDynamoDB client)
  {
    this.client = client;
  }
  
  public DescribeTableResult apply(DescribeTableRequest describeTableRequest)
  {
    return client.describeTable(describeTableRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.waiters.DescribeTableFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */