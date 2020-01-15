package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduce;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeClusterResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class DescribeClusterFunction
  implements SdkFunction<DescribeClusterRequest, DescribeClusterResult>
{
  private final AmazonElasticMapReduce client;
  
  public DescribeClusterFunction(AmazonElasticMapReduce client)
  {
    this.client = client;
  }
  
  public DescribeClusterResult apply(DescribeClusterRequest describeClusterRequest)
  {
    return client.describeCluster(describeClusterRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters.DescribeClusterFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */