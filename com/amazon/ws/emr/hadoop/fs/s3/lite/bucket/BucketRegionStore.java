package com.amazon.ws.emr.hadoop.fs.s3.lite.bucket;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import javax.annotation.Nullable;

public abstract interface BucketRegionStore
{
  @Nullable
  public abstract Region get(String paramString);
  
  public abstract void put(String paramString, Region paramRegion);
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.bucket.BucketRegionStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */