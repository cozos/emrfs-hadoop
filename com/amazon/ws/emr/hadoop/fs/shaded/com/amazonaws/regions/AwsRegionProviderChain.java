package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.auth.AWSCredentialsProviderChain;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AwsRegionProviderChain
  extends AwsRegionProvider
{
  private static final Log LOG = LogFactory.getLog(AWSCredentialsProviderChain.class);
  private final List<AwsRegionProvider> providers;
  
  public AwsRegionProviderChain(AwsRegionProvider... providers)
  {
    this.providers = new ArrayList(providers.length);
    Collections.addAll(this.providers, providers);
  }
  
  public String getRegion()
    throws SdkClientException
  {
    for (AwsRegionProvider provider : providers) {
      try
      {
        String region = provider.getRegion();
        if (region != null) {
          return region;
        }
      }
      catch (Exception e)
      {
        LOG.debug("Unable to load region from " + provider.toString() + ": " + e
          .getMessage());
      }
    }
    throw new SdkClientException("Unable to load region information from any provider in the chain");
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.AwsRegionProviderChain
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */