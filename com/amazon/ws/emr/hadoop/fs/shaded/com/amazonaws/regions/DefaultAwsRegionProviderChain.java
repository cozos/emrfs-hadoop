package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

public class DefaultAwsRegionProviderChain
  extends AwsRegionProviderChain
{
  public DefaultAwsRegionProviderChain()
  {
    super(new AwsRegionProvider[] { new AwsEnvVarOverrideRegionProvider(), new AwsSystemPropertyRegionProvider(), new AwsProfileRegionProvider(), new InstanceMetadataRegionProvider() });
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.DefaultAwsRegionProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */