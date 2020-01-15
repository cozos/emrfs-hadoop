package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SDKGlobalConfiguration;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.EC2MetadataUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;

public class InstanceMetadataRegionProvider
  extends AwsRegionProvider
{
  private static final Log LOG = LogFactory.getLog(InstanceMetadataRegionProvider.class);
  private volatile String region;
  
  public String getRegion()
  {
    if (SDKGlobalConfiguration.isEc2MetadataDisabled()) {
      throw new AmazonClientException("AWS_EC2_METADATA_DISABLED is set to true, not loading region from EC2 Instance Metadata service");
    }
    if (region == null) {
      synchronized (this)
      {
        if (region == null) {
          region = tryDetectRegion();
        }
      }
    }
    return region;
  }
  
  private String tryDetectRegion()
  {
    try
    {
      return EC2MetadataUtils.getEC2InstanceRegion();
    }
    catch (AmazonClientException sce)
    {
      LOG.debug("Ignoring failure to retrieve the region: " + sce.getMessage());
    }
    return null;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.InstanceMetadataRegionProvider
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */