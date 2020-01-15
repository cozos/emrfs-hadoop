package com.amazonaws.services.sqs;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
class AmazonSQSClientConfigurationFactory
  extends ClientConfigurationFactory
{
  protected ClientConfiguration getInRegionOptimizedConfig()
  {
    return super.getInRegionOptimizedConfig().withSocketTimeout(25000);
  }
}

/* Location:
 * Qualified Name:     com.amazonaws.services.sqs.AmazonSQSClientConfigurationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */