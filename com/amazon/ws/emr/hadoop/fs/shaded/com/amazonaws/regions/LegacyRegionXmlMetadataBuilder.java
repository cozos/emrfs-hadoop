package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.annotation.SdkInternalApi;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.internal.config.Builder;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.IOUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.Log;
import com.amazon.ws.emr.hadoop.fs.shaded.org.apache.commons.logging.LogFactory;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

@SdkInternalApi
public class LegacyRegionXmlMetadataBuilder
  implements Builder<RegionMetadata>
{
  private static final String REGIONS_FILE_OVERRIDE = "com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils.fileOverride";
  private static final String OVERRIDE_ENDPOINTS_RESOURCE_PATH = "/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/regions/override/regions.xml";
  private static final Log LOG = LogFactory.getLog(LegacyRegionXmlMetadataBuilder.class);
  
  public RegionMetadata build()
  {
    return loadOverrideMetadataIfExists();
  }
  
  private RegionMetadata loadOverrideMetadataIfExists()
  {
    RegionMetadata metadata = loadFromSystemProperty();
    if (metadata == null)
    {
      InputStream override = RegionUtils.class.getResourceAsStream("/com/amazon/ws/emr/hadoop/fs/shaded/com/amazonaws/regions/override/regions.xml");
      if (override != null)
      {
        metadata = loadFromStream(override);
        IOUtils.closeQuietly(override, LOG);
      }
    }
    return metadata;
  }
  
  private RegionMetadata loadFromSystemProperty()
  {
    String overrideFilePath = System.getProperty("com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionUtils.fileOverride");
    if (overrideFilePath != null) {
      try
      {
        return LegacyRegionXmlLoadUtils.load(new File(overrideFilePath));
      }
      catch (IOException exception)
      {
        throw new SdkClientException("Error parsing region metadata from " + overrideFilePath, exception);
      }
    }
    return null;
  }
  
  private RegionMetadata loadFromStream(InputStream stream)
  {
    try
    {
      return LegacyRegionXmlLoadUtils.load(stream);
    }
    catch (IOException exception)
    {
      throw new SdkClientException("Error parsing region metadata from input stream", exception);
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.LegacyRegionXmlMetadataBuilder
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */