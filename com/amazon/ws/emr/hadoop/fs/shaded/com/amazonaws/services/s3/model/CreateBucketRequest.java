package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class CreateBucketRequest
  extends AmazonWebServiceRequest
  implements Serializable, S3AccelerateUnsupported
{
  private String bucketName;
  @Deprecated
  private String region;
  private CannedAccessControlList cannedAcl;
  private AccessControlList accessControlList;
  private boolean objectLockEnabled;
  
  public CreateBucketRequest(String bucketName)
  {
    this(bucketName, Region.US_Standard);
  }
  
  public CreateBucketRequest(String bucketName, Region region)
  {
    this(bucketName, region.toString());
  }
  
  public CreateBucketRequest(String bucketName, String region)
  {
    setBucketName(bucketName);
    setRegion(region);
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  @Deprecated
  public void setRegion(String region)
  {
    this.region = region;
  }
  
  @Deprecated
  public String getRegion()
  {
    return region;
  }
  
  public CannedAccessControlList getCannedAcl()
  {
    return cannedAcl;
  }
  
  public void setCannedAcl(CannedAccessControlList cannedAcl)
  {
    this.cannedAcl = cannedAcl;
  }
  
  public CreateBucketRequest withCannedAcl(CannedAccessControlList cannedAcl)
  {
    setCannedAcl(cannedAcl);
    return this;
  }
  
  public AccessControlList getAccessControlList()
  {
    return accessControlList;
  }
  
  public void setAccessControlList(AccessControlList accessControlList)
  {
    this.accessControlList = accessControlList;
  }
  
  public CreateBucketRequest withAccessControlList(AccessControlList accessControlList)
  {
    setAccessControlList(accessControlList);
    return this;
  }
  
  public boolean getObjectLockEnabledForBucket()
  {
    return objectLockEnabled;
  }
  
  public CreateBucketRequest withObjectLockEnabledForBucket(boolean objectLockEnabled)
  {
    this.objectLockEnabled = objectLockEnabled;
    return this;
  }
  
  public void setObjectLockEnabledForBucket(boolean objectLockEnabled)
  {
    withObjectLockEnabledForBucket(objectLockEnabled);
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.CreateBucketRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */