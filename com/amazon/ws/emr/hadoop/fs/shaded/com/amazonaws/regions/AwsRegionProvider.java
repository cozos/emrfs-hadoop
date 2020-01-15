package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public abstract class AwsRegionProvider
{
  public abstract String getRegion()
    throws SdkClientException;
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsRegionProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */