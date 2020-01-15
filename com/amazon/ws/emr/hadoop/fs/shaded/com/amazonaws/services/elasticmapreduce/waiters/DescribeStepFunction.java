package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.AmazonElasticMapReduce;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.model.DescribeStepResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class DescribeStepFunction
  implements SdkFunction<DescribeStepRequest, DescribeStepResult>
{
  private final AmazonElasticMapReduce client;
  
  public DescribeStepFunction(AmazonElasticMapReduce client)
  {
    this.client = client;
  }
  
  public DescribeStepResult apply(DescribeStepRequest describeStepRequest)
  {
    return client.describeStep(describeStepRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.elasticmapreduce.waiters.DescribeStepFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */