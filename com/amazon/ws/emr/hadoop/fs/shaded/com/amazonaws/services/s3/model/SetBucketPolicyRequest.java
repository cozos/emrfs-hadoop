package com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model;

import com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.AmazonWebServiceRequest;
import java.io.Serializable;

public class SetBucketPolicyRequest
  extends AmazonWebServiceRequest
  implements Serializable
{
  private String bucketName;
  private String policyText;
  private Boolean confirmRemoveSelfBucketAccess;
  
  public SetBucketPolicyRequest(String bucketName, String policyText)
  {
    this.bucketName = bucketName;
    this.policyText = policyText;
  }
  
  public String getBucketName()
  {
    return bucketName;
  }
  
  public void setBucketName(String bucketName)
  {
    this.bucketName = bucketName;
  }
  
  public SetBucketPolicyRequest withBucketName(String bucketName)
  {
    setBucketName(bucketName);
    return this;
  }
  
  public String getPolicyText()
  {
    return policyText;
  }
  
  public void setPolicyText(String policyText)
  {
    this.policyText = policyText;
  }
  
  public SetBucketPolicyRequest withPolicyText(String policyText)
  {
    setPolicyText(policyText);
    return this;
  }
  
  public Boolean getConfirmRemoveSelfBucketAccess()
  {
    return confirmRemoveSelfBucketAccess;
  }
  
  public void setConfirmRemoveSelfBucketAccess(Boolean confirmRemoveSelfBucketAccess)
  {
    this.confirmRemoveSelfBucketAccess = confirmRemoveSelfBucketAccess;
  }
  
  public SetBucketPolicyRequest withConfirmRemoveSelfBucketAccess(Boolean confirmRemoveSelfBucketAccess)
  {
    setConfirmRemoveSelfBucketAccess(confirmRemoveSelfBucketAccess);
    return this;
  }
}

/* Location:
 * Qualified Name:     com.amazon.ws.emr.hadoop.fs.shaded.com.amazonaws.services.s3.model.SetBucketPolicyRequest
 * Java Class Version: 6 (50.0)
 * JD-Core Version:    0.7.1
 */