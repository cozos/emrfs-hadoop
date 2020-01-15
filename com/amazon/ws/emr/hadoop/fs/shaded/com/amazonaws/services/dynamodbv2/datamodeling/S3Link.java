package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.SdkClientException;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.metrics.RequestMetricCollector;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.AmazonS3;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.internal.BucketNameUtils;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.AccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.GetObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.PutObjectResult;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.Region;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3Object;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.S3ObjectInputStream;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectAclRequest;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.transfer.TransferManager;
import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.util.json.Jackson;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonIgnore;
import com.amazon.ws.emr.hadoop.fs.shaded.com.fasterxml.jackson.annotation.JsonProperty;
import com.amazonaws.auth.AWSCredentialsProvider;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;

public class S3Link
{
  private final S3ClientCache s3cc;
  private final ID id;
  
  S3Link(S3ClientCache s3cc, String bucketName, String key)
  {
    this(s3cc, new ID(bucketName, key));
  }
  
  S3Link(S3ClientCache s3cc, String region, String bucketName, String key)
  {
    this(s3cc, new ID(region, bucketName, key));
  }
  
  private S3Link(S3ClientCache s3cc, ID id)
  {
    this.s3cc = s3cc;
    this.id = id;
    if (s3cc == null) {
      throw new IllegalArgumentException("S3ClientCache must be configured for use with S3Link");
    }
    if ((id == null) || (id.getBucket() == null) || (id.getKey() == null)) {
      throw new IllegalArgumentException("Bucket and key must be specified for S3Link");
    }
  }
  
  public String getKey()
  {
    return id.getKey();
  }
  
  public String getBucketName()
  {
    return id.getBucket();
  }
  
  public Region getS3Region()
  {
    return Region.fromValue(getRegion());
  }
  
  public String getRegion()
  {
    return id.getRegionId() == null ? "us-east-1" : id.getRegionId();
  }
  
  public String toJson()
  {
    return id.toJson();
  }
  
  public static S3Link fromJson(S3ClientCache s3cc, String json)
  {
    ID id = (ID)Jackson.fromJsonString(json, ID.class);
    return new S3Link(s3cc, id);
  }
  
  public AmazonS3 getAmazonS3Client()
  {
    return s3cc.getClient(getRegion());
  }
  
  public TransferManager getTransferManager()
  {
    return s3cc.getTransferManager(getRegion());
  }
  
  public PutObjectResult uploadFrom(File source)
  {
    return uploadFrom0(source, null);
  }
  
  public PutObjectResult uploadFrom(File source, RequestMetricCollector requestMetricCollector)
  {
    return uploadFrom0(source, requestMetricCollector);
  }
  
  private PutObjectResult uploadFrom0(File source, RequestMetricCollector requestMetricCollector)
  {
    PutObjectRequest req = (PutObjectRequest)new PutObjectRequest(getBucketName(), getKey(), source).withRequestMetricCollector(requestMetricCollector);
    return getAmazonS3Client().putObject(req);
  }
  
  public PutObjectResult uploadFrom(byte[] buffer)
  {
    return uploadFrom0(buffer, null);
  }
  
  public PutObjectResult uploadFrom(byte[] buffer, RequestMetricCollector requestMetricCollector)
  {
    return uploadFrom0(buffer, requestMetricCollector);
  }
  
  private PutObjectResult uploadFrom0(byte[] buffer, RequestMetricCollector requestMetricCollector)
  {
    ObjectMetadata objectMetadata = new ObjectMetadata();
    objectMetadata.setContentLength(buffer.length);
    
    PutObjectRequest req = (PutObjectRequest)new PutObjectRequest(getBucketName(), getKey(), new ByteArrayInputStream(buffer), objectMetadata).withRequestMetricCollector(requestMetricCollector);
    return getAmazonS3Client().putObject(req);
  }
  
  public void setAcl(CannedAccessControlList acl)
  {
    setAcl0(acl, null);
  }
  
  public void setAcl(CannedAccessControlList acl, RequestMetricCollector col)
  {
    setAcl0(acl, col);
  }
  
  private void setAcl0(CannedAccessControlList acl, RequestMetricCollector col)
  {
    SetObjectAclRequest setObjectAclRequest = (SetObjectAclRequest)new SetObjectAclRequest(getBucketName(), getKey(), acl).withRequestMetricCollector(col);
    getAmazonS3Client().setObjectAcl(setObjectAclRequest);
  }
  
  public void setAcl(AccessControlList acl)
  {
    setAcl0(acl, null);
  }
  
  public void setAcl(AccessControlList acl, RequestMetricCollector requestMetricCollector)
  {
    setAcl0(acl, requestMetricCollector);
  }
  
  private void setAcl0(AccessControlList acl, RequestMetricCollector requestMetricCollector)
  {
    SetObjectAclRequest setObjectAclRequest = (SetObjectAclRequest)new SetObjectAclRequest(getBucketName(), getKey(), acl).withRequestMetricCollector(requestMetricCollector);
    getAmazonS3Client().setObjectAcl(setObjectAclRequest);
  }
  
  public URL getUrl()
  {
    return getAmazonS3Client().getUrl(getBucketName(), getKey());
  }
  
  public ObjectMetadata downloadTo(File destination)
  {
    return downloadTo0(destination, null);
  }
  
  public ObjectMetadata downloadTo(File destination, RequestMetricCollector requestMetricCollector)
  {
    return downloadTo0(destination, requestMetricCollector);
  }
  
  private ObjectMetadata downloadTo0(File destination, RequestMetricCollector requestMetricCollector)
  {
    GetObjectRequest req = (GetObjectRequest)new GetObjectRequest(getBucketName(), getKey()).withRequestMetricCollector(requestMetricCollector);
    return getAmazonS3Client().getObject(req, destination);
  }
  
  public ObjectMetadata downloadTo(OutputStream output)
  {
    return downloadTo0(output, null);
  }
  
  public ObjectMetadata downloadTo(OutputStream output, RequestMetricCollector requestMetricCollector)
  {
    return downloadTo0(output, requestMetricCollector);
  }
  
  private ObjectMetadata downloadTo0(OutputStream output, RequestMetricCollector requestMetricCollector)
  {
    GetObjectRequest req = (GetObjectRequest)new GetObjectRequest(getBucketName(), getKey()).withRequestMetricCollector(requestMetricCollector);
    s3Object = getAmazonS3Client().getObject(req);
    S3ObjectInputStream objectContent = s3Object.getObjectContent();
    try
    {
      byte[] buffer = new byte['⠀'];
      int bytesRead = -1;
      while ((bytesRead = objectContent.read(buffer)) > -1) {
        output.write(buffer, 0, bytesRead);
      }
      return s3Object.getObjectMetadata();
    }
    catch (IOException ioe)
    {
      objectContent.abort();
      throw new SdkClientException("Unable to transfer content from Amazon S3 to the output stream", ioe);
    }
    finally
    {
      try
      {
        objectContent.close();
      }
      catch (IOException localIOException2) {}
    }
  }
  
  static class ID
  {
    @JsonProperty("s3")
    private S3Link.S3 s3;
    
    ID() {}
    
    ID(String bucketName, String key)
    {
      s3 = new S3Link.S3(bucketName, key);
    }
    
    ID(String region, String bucketName, String key)
    {
      s3 = new S3Link.S3(region, bucketName, key);
    }
    
    ID(S3Link.S3 s3)
    {
      this.s3 = s3;
    }
    
    @JsonProperty("s3")
    public S3Link.S3 getS3()
    {
      return s3;
    }
    
    @JsonIgnore
    public String getRegionId()
    {
      return s3.getRegionId();
    }
    
    @JsonIgnore
    public String getBucket()
    {
      return s3.getBucket();
    }
    
    @JsonIgnore
    public String getKey()
    {
      return s3.getKey();
    }
    
    String toJson()
    {
      return Jackson.toJsonString(this);
    }
  }
  
  private static class S3
  {
    @JsonProperty("bucket")
    private String bucket;
    @JsonProperty("key")
    private String key;
    @JsonProperty("region")
    private String regionId;
    
    S3() {}
    
    S3(String bucket, String key)
    {
      this(null, bucket, key);
    }
    
    S3(String region, String bucket, String key)
    {
      regionId = region;
      this.bucket = bucket;
      this.key = key;
    }
    
    @JsonProperty("bucket")
    public String getBucket()
    {
      return bucket;
    }
    
    @JsonProperty("key")
    public String getKey()
    {
      return key;
    }
    
    @JsonProperty("region")
    public String getRegionId()
    {
      return regionId;
    }
  }
  
  public static final class Factory
    implements DynamoDBTypeConverter<String, S3Link>
  {
    static final Factory DEFAULT = new Factory((S3ClientCache)null);
    private final S3ClientCache s3cc;
    
    public static final Factory of(AWSCredentialsProvider provider)
    {
      return provider == null ? DEFAULT : new Factory(new S3ClientCache(provider));
    }
    
    public Factory(S3ClientCache s3cc)
    {
      this.s3cc = s3cc;
    }
    
    public S3Link createS3Link(Region s3region, String bucketName, String key)
    {
      return createS3Link(S3Link.convertRegionToString(s3region, bucketName), bucketName, key);
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
  
  private static String convertRegionToString(Region region, String bucketName)
  {
    String regionAsString;
    if (region == null)
    {
      String regionAsString;
      if (BucketNameUtils.isDNSBucketName(bucketName)) {
        regionAsString = Region.US_Standard.getFirstRegionId();
      } else {
        throw new IllegalArgumentException("Region must be specified for bucket that cannot be addressed using virtual host style");
      }
    }
    else
    {
      regionAsString = region.getFirstRegionId();
    }
    return regionAsString;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.dynamodbv2.datamodeling.S3Link
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */