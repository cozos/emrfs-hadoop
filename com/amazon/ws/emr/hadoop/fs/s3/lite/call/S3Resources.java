package com.amazon.ws.emr.hadoop.fs.s3.lite.call;

import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.base.Strings;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.google.common.collect.ImmutableList.Builder;
import java.util.Collection;

final class S3Resources
{
  static Collection<S3Resource> fromBucket(String bucketName)
  {
    return ImmutableList.of(newS3Bucket(bucketName));
  }
  
  static Collection<S3Resource> fromBucketAndKey(String bucketName, String key)
  {
    return ImmutableList.of(newS3Object(bucketName, key));
  }
  
  static Collection<S3Resource> fromBucketAndPrefix(String bucketName, String prefix)
  {
    return ImmutableList.of(newS3Prefix(bucketName, prefix));
  }
  
  static Collection<S3Resource> fromSourceAndDestination(String sourceBucketName, String sourceKey, String destinationBucketName, String destinationKey)
  {
    return ImmutableList.of(
      newS3Object(sourceBucketName, sourceKey), 
      newS3Object(destinationBucketName, destinationKey));
  }
  
  static Collection<S3Resource> fromBucketAndKeys(String bucketName, Collection<String> keys)
  {
    ImmutableList.Builder<S3Resource> builder = ImmutableList.builder();
    for (String key : keys) {
      builder.add(newS3Object(bucketName, key));
    }
    return builder.build();
  }
  
  private static S3Resource newS3Bucket(String bucketName)
  {
    return new GenericS3Resource(S3Resource.Type.BUCKET, bucketName, null, null);
  }
  
  private static S3Resource newS3Object(String bucketName, String key)
  {
    return new GenericS3Resource(S3Resource.Type.OBJECT, bucketName, key, null);
  }
  
  private static S3Resource newS3Prefix(String bucketName, String prefix)
  {
    return new GenericS3Resource(S3Resource.Type.PREFIX, bucketName, prefix, null);
  }
  
  private static final class GenericS3Resource
    implements S3Resource
  {
    private final S3Resource.Type type;
    private final String bucketName;
    private final String path;
    
    private GenericS3Resource(S3Resource.Type type, String bucketName, String path)
    {
      this.type = type;
      this.bucketName = bucketName;
      this.path = path;
    }
    
    public S3Resource.Type getType()
    {
      return type;
    }
    
    public String getBucketName()
    {
      return bucketName;
    }
    
    public String getPath()
    {
      return path;
    }
    
    public String toString()
    {
      if (!Strings.isNullOrEmpty(path)) {
        return type + " : " + bucketName + "/" + path;
      }
      return type + " : " + bucketName;
    }
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.s3.lite.call.S3Resources
 * Java Class Version: 8 (52.0)
 * JD-Core Version:    0.7.1
 */