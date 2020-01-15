package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkProtectedApi;

@SdkProtectedApi
public abstract interface AwsResource
{
  public abstract String getPartition();
  
  public abstract String getRegion();
  
  public abstract String getAccountId();
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.arn.AwsResource
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */