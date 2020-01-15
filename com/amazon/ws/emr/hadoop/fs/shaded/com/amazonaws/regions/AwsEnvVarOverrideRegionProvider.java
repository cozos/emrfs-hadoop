package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class AwsEnvVarOverrideRegionProvider
  extends AwsRegionProvider
{
  public String getRegion()
    throws SdkClientException
  {
    return System.getenv("AWS_REGION");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsEnvVarOverrideRegionProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */