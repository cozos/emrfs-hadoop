package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.AmazonCloudWatch;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.model.DescribeAlarmsResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.waiters.SdkFunction;

@SdkInternalApi
public class DescribeAlarmsFunction
  implements SdkFunction<DescribeAlarmsRequest, DescribeAlarmsResult>
{
  private final AmazonCloudWatch client;
  
  public DescribeAlarmsFunction(AmazonCloudWatch client)
  {
    this.client = client;
  }
  
  public DescribeAlarmsResult apply(DescribeAlarmsRequest describeAlarmsRequest)
  {
    return client.describeAlarms(describeAlarmsRequest);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.cloudwatch.waiters.DescribeAlarmsFunction
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */