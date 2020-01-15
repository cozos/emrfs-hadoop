package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;

public class AwsSystemPropertyRegionProvider
  extends AwsRegionProvider
{
  public String getRegion()
    throws SdkClientException
  {
    return System.getProperty("aws.region");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsSystemPropertyRegionProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */