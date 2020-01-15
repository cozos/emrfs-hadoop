package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region;
import com.amazonaws.auth.AWSCredentialsProvider;

public final class S3Link$Factory
  implements DynamoDBTypeConverter<String, S3Link>
{
  static final Factory DEFAULT = new Factory((S3ClientCache)null);
  private final S3ClientCache s3cc;
  
  public static final Factory of(AWSCredentialsProvider provider)
  {
    return provider == null ? DEFAULT : new Factory(new S3ClientCache(provider));
  }
  
  public S3Link$Factory(S3ClientCache s3cc)
  {
    this.s3cc = s3cc;
  }
  
  public S3Link createS3Link(Region s3region, String bucketName, String key)
  {
    return createS3Link(S3Link.access$000(s3region, bucketName), bucketName, key);
  }
  
  public S3Link createS3Link(String s3region, String bucketName, String key)
  {
    if (getS3ClientCache() == null) {
      throw new IllegalStateException("Mapper must be constructed with S3 AWS Credentials to create S3Link");
    }
    return new S3Link(getS3ClientCache(), s3region, bucketName, key);
  }
  
  public S3ClientCache getS3ClientCache()
  {
    return s3cc;
  }
  
  public String convert(S3Link o)
  {
    return (o.getBucketName() == null) || (o.getKey() == null) ? null : o.toJson();
  }
  
  public S3Link unconvert(String o)
  {
    return S3Link.fromJson(getS3ClientCache(), o);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3Link.Factory
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */