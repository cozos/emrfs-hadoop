package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetObjectAclRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private final String bucketName;
  private final String key;
  private final String versionId;
  private final AccessControlList acl;
  private final CannedAccessControlList cannedAcl;
  private boolean isRequesterPays;
  
  public SetObjectAclRequest(String bucketName, String key, AccessControlList acl)
  {
    this.bucketName = bucketName;
    this.key = key;
    versionId = null;
    
    this.acl = acl;
    cannedAcl = null;
  }
  
  public SetObjectAclRequest(String bucketName, String key, CannedAccessControlList acl)
  {
    this.bucketName = bucketName;
    this.key = key;
    versionId = null;
    
    this.acl = null;
    cannedAcl = acl;
  }
  
  public SetObjectAclRequest(String bucketName, String key, String versionId, AccessControlList acl)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.versionId = versionId;
    
    this.acl = acl;
    cannedAcl = null;
  }
  
  public SetObjectAclRequest(String bucketName, String key, String versionId, CannedAccessControlList acl)
  {
    this.bucketName = bucketName;
    this.key = key;
    this.versionId = versionId;
    
    this.acl = null;
    cannedAcl = acl;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public String getKey()
  {
    return key;
  }
  
  public String getVersionId()
  {
    return versionId;
  }
  
  public AccessControlList getAcl()
  {
    return acl;
  }
  
  public CannedAccessControlList getCannedAcl()
  {
    return cannedAcl;
  }
  
  public boolean isRequesterPays()
  {
    return isRequesterPays;
  }
  
  public void setRequesterPays(boolean isRequesterPays)
  {
    this.isRequesterPays = isRequesterPays;
  }
  
  public SetObjectAclRequest withRequesterPays(boolean isRequesterPays)
  {
    setRequesterPays(isRequesterPays);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetObjectAclRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */