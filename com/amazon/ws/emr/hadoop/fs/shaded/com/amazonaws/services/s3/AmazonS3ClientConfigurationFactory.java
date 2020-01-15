package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.ClientConfigurationFactory;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;

@SdkInternalApi
class AmazonS3ClientConfigurationFactory
  extends ClientConfigurationFactory
{
  protected ClientConfiguration getInRegionOptimizedConfig()
  {
    return super.getInRegionOptimizedConfig().withSocketTimeout(21000);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3ClientConfigurationFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */