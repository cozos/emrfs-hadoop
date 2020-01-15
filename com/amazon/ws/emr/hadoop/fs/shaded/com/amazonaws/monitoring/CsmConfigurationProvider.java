package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public abstract interface CsmConfigurationProvider
{
  public abstract CsmConfiguration getConfiguration()
    throws SdkClientException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.monitoring.CsmConfigurationProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */