package com.amazon.ws.emr.hadoop.fs.s3.lite.bucket;

public final class BucketRegionStores
{
  private BucketRegionStores()
  {
    throw new AssertionError();
  }
  
  public static BucketRegionStore inMemoryStore()
  {
    return new InMemoryBucketRegionStore();
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.bucket.BucketRegionStores
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */