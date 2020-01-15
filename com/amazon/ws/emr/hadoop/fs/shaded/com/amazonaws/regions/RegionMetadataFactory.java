package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.partitions.PartitionsLoader;

public class RegionMetadataFactory
{
  public static RegionMetadata create()
  {
    RegionMetadata metadata = createLegacyXmlRegionMetadata();
    if (metadata == null) {
      metadata = new RegionMetadata(new PartitionsLoader().build());
    }
    return metadata;
  }
  
  private static RegionMetadata createLegacyXmlRegionMetadata()
  {
    return new LegacyRegionXmlMetadataBuilder().build();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.RegionMetadataFactory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */