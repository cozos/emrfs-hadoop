package com.amazon.ws.emr.hadoop.fs.s3.lite.bucket;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.regions.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Preconditions;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.Cache;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.cache.CacheBuilder;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

@ThreadSafe
final class InMemoryBucketRegionStore
  implements BucketRegionStore
{
  private static final int DEFAULT_MAXIMUM_SIZE = 300;
  private final Cache<String, Region> bucketToRegion;
  
  InMemoryBucketRegionStore()
  {
    this(300L);
  }
  
  InMemoryBucketRegionStore(long maximumSize)
  {
    bucketToRegion = CacheBuilder.newBuilder().maximumSize(maximumSize).build();
  }
  
  @Nullable
  public Region get(String bucketName)
  {
    Preconditions.checkNotNull(bucketName, "Bucket name is required");
    return (Region)bucketToRegion.getIfPresent(bucketName);
  }
  
  public void put(String bucketName, Region region)
  {
    Preconditions.checkNotNull(bucketName, "Bucket name is required");
    Preconditions.checkNotNull(region, "Region is required");
    bucketToRegion.put(bucketName, region);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.bucket.InMemoryBucketRegionStore
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */