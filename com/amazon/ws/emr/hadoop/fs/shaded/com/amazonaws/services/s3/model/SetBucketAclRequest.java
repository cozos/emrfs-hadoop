package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketAclRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private AccessControlList acl;
  private CannedAccessControlList cannedAcl;
  
  public SetBucketAclRequest(String bucketName, AccessControlList acl)
  {
    this.bucketName = bucketName;
    this.acl = acl;
    cannedAcl = null;
  }
  
  public SetBucketAclRequest(String bucketName, CannedAccessControlList acl)
  {
    this.bucketName = bucketName;
    this.acl = null;
    cannedAcl = acl;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public AccessControlList getAcl()
  {
    return acl;
  }
  
  public CannedAccessControlList getCannedAcl()
  {
    return cannedAcl;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketAclRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */